package com.bailian.car.utils;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import org.apache.commons.collections.MapUtils;
import com.bailian.car.exception.ParamException;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

/**
 * 
 * @ClassName: BeanValidator
 * @Description: 校验类
 * @author itastro
 * @date 2017年12月16日
 *
 */
public class BeanValidator {

	// 定义自己的Validator 工厂
	private static ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();

	public static <T> Map<String, String> validate(T t, Class<?>... groups) {
		// 获得validator
		Validator validator = validatorFactory.getValidator();
		// 自动得获取校验的一个结果
		Set<?> validateResult = validator.validate(t, groups);
		// 如果是空
		if (validateResult.isEmpty()) {
			return Collections.emptyMap();
		} else {
			LinkedHashMap<String, String> errors = Maps.newLinkedHashMap();

			Iterator<?> iterator = validateResult.iterator();

			while (iterator.hasNext()) {
				// 获取下一个值
				ConstraintViolation<?> vaViolation = (ConstraintViolation<?>) iterator.next();
				// 获取属性 以及错误信息
				errors.put(vaViolation.getPropertyPath().toString(), vaViolation.getMessage());
			}
			return errors;
		}

	}

	// 返回map的对象
	public static Map<String, String> validateList(Collection<?> collection) {

		// 校验collection是否为空
		Preconditions.checkNotNull(collection);
		// 遍历
		Iterator<?> iterator = collection.iterator();

		Map<String, String> errors;
		// 遍历
		do {
			if (!iterator.hasNext()) {
				return Collections.emptyMap();
			}
			Object object = iterator.next();
			errors = validate(object, new Class[0]);
		} while (errors.isEmpty());

		return errors;

	}

	// 校验 任何方法只用这一个校验
	public static Map<String, String> validateObject(Object first, Object... objects) {
		// 判断是否是数组
		if (objects != null && objects.length > 0) {
			return validateList(Lists.asList(first, objects));
		} else {
			return validate(first, new Class[0]);
		}

	}

	// 校验参数
	public static void check(Object param) throws ParamException {
		Map<String, String> map = BeanValidator.validateObject(param);

		if (MapUtils.isNotEmpty(map)) {
			throw new ParamException(map.toString());
		}
	}
}
