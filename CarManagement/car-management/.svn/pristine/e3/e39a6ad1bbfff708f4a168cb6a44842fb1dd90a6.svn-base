package com.bailian.car.filter;

import java.util.Set;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.CollectionUtils;
import org.apache.shiro.web.filter.authz.AuthorizationFilter;

import com.bailian.car.domain.system.User;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AnyRolesAuthorizationFilter extends AuthorizationFilter {

	@Override
	protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue)
			throws Exception {
		// TODO Auto-generated method stub

		Subject subject = getSubject(request, response);
		User principal = (User) subject.getPrincipal();
		log.info("" + principal.getNickname());
		String[] rolesArray = (String[]) mappedValue;

		if (rolesArray == null || rolesArray.length == 0) {
			return true;
		}

		Set<String> roles = CollectionUtils.asSet(rolesArray);

		for (String role : roles) {
			if (subject.hasRole(role)) {
				return true;
			}

		}
		return false;
	}

}
