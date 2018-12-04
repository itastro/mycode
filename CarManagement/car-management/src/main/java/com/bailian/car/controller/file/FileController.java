package com.bailian.car.controller.file;
import java.io.File;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import com.bailian.car.common.JsonData;
import com.bailian.car.dao.cars.car.CarBaseRepository;
import com.bailian.car.dao.cars.car.CarRepository;
import com.bailian.car.domain.cars.car.Car;
import com.bailian.car.domain.cars.car.CarBase;
import com.bailian.car.exception.PermissionException;
import com.bailian.car.service.cars.car.CarService;

@Controller()
@RequestMapping("/file")
public class FileController {

	@Autowired
	private CarService carService;

	@Autowired
	private CarRepository carRepository;

	@Autowired
	private CarBaseRepository carBaseRepository;

	// 文件上传
	@RequestMapping("/circuitPicUpload.action")
	@ResponseBody
	public JsonData fileUpload(HttpServletRequest request, HttpServletResponse response, HttpSession httpSession) {

		try {
			Thread.sleep(200);
			MultipartFile multipartFile = null;
			if (request instanceof MultipartHttpServletRequest) {
				multipartFile = ((MultipartHttpServletRequest) request).getFile("file");
			}

			String vSn = request.getParameter("vSn");
			Car car = carRepository.findByvSn(vSn);
			CarBase carBase = carBaseRepository.findByvSn(vSn);
			if (multipartFile != null) {

				if (multipartFile.getSize() <= 0) {
					return JsonData.fail("请选择电路图文件");
				}
				// 项目服务器地址路径
				String projectServerPath = request.getScheme() + "://" + request.getServerName() + ":"
						+ request.getServerPort() + request.getContextPath() + "/file/";
				// 上传文件的绝对路径
				// String realPath =
				// request.getSession().getServletContext().getRealPath("/file/");
				// 上传文件名

				String realPath = "D://carfile//circuit";
				String filename = vSn + multipartFile.getOriginalFilename().replaceAll(" ", "");
				File file = new File(realPath + filename);

				// 判断路径是否存在
				if (!file.getParentFile().exists()) {
					file.getParentFile().mkdirs();
				}
				// 创建文件
				multipartFile.transferTo(new File(realPath + File.separator + filename));
				// 返回服务器文件地址
				// String serverFilePatn = projectServerPath + filename;
				car.setCircuiturl(realPath);
				car.setCircuitName(filename);
				carBase.setCircuitName(filename);
				carBase.setCircuiturl(realPath);
				carRepository.save(car);
				carBaseRepository.save(carBase);
				return JsonData.success(realPath, "文件上传成功");
			}

		} catch (Exception e) {
			throw new PermissionException("文件不能大于50M");
		}
		return JsonData.fail("文件不能为空");
	}

	// 文件上传
	@RequestMapping("/bomUpload.action")
	@ResponseBody
	public JsonData bomUpload(HttpServletRequest request, HttpServletResponse response, HttpSession httpSession)
			throws IllegalStateException, IOException, InterruptedException {
		// try {

		Thread.sleep(200);

		MultipartFile multipartFile = null;
		if (request instanceof MultipartHttpServletRequest) {
			multipartFile = ((MultipartHttpServletRequest) request).getFile("file");
		}

		String vSn = request.getParameter("vSn");
		Car car = carRepository.findByvSn(vSn);
		CarBase carBase = carBaseRepository.findByvSn(vSn);
		if (multipartFile != null) {
			if (multipartFile.getSize() <= 0) {
				return JsonData.fail("请选择bom文件");
			}
			// 上传文件的绝对路径
			String realPath = "E:\\bailian\\datafile\\bom";
			// 项目服务器地址路径
			String projectServerPath = request.getScheme() + "://" + request.getServerName() + ":"
					+ request.getServerPort() + request.getContextPath() + "/"+"bom"+"/";

			String filename = vSn + multipartFile.getOriginalFilename().replaceAll(" ", "");
			File file = new File(realPath + filename);

			// 判断路径是否存在
			if (!file.getParentFile().exists()) {
				file.getParentFile().mkdirs();
			}
			// 创建文件
			multipartFile.transferTo(new File(realPath + File.separator + filename));
			// 返回服务器文件地址
			String serverFilePatn = projectServerPath + filename;
			car.setWordurl(serverFilePatn);
			car.setWordName(serverFilePatn);
			carBase.setWordurl(serverFilePatn);
			carBase.setWordName(serverFilePatn);
			carRepository.save(car);
			carBaseRepository.save(carBase);
			return JsonData.success(serverFilePatn, "文件上传成功");
		}
		/*
		 * } catch (Exception e) { throw new PermissionException("文件上传失败"); }
		 */
		return JsonData.fail("文件不能为空");
	}

	// 文件上传
	@RequestMapping("/wordUpload.action")
	@ResponseBody
	public JsonData wordUpload(HttpServletRequest request, HttpServletResponse response, HttpSession httpSession) {
		try {

			Thread.sleep(200);

			MultipartFile multipartFile = null;
			if (request instanceof MultipartHttpServletRequest) {
				multipartFile = ((MultipartHttpServletRequest) request).getFile("file");
			}

			String vSn = request.getParameter("vSn");
			Car car = carRepository.findByvSn(vSn);
			CarBase carBase = carBaseRepository.findByvSn(vSn);
			if (multipartFile != null) {
				if (multipartFile.getSize() <= 0) {
					return JsonData.fail("请选择crf文件");
				}
				// 项目服务器地址路径
				String projectServerPath = request.getScheme() + "://" + request.getServerName() + ":"
						+ request.getServerPort() + request.getContextPath() + "/file/";
				// 上传文件的绝对路径
				// String realPath =
				// request.getSession().getServletContext().getRealPath("/file/");
				// 上传文件名

				String realPath = "D://carfile//word";
				String filename = vSn + multipartFile.getOriginalFilename().replaceAll(" ", "");
				File file = new File(realPath + filename);

				// 判断路径是否存在
				if (!file.getParentFile().exists()) {
					file.getParentFile().mkdirs();
				}
				// 创建文件
				multipartFile.transferTo(new File(realPath + File.separator + filename));
				// 返回服务器文件地址
				String serverFilePatn = projectServerPath + filename;
				car.setWordurl(realPath);
				car.setWordName(filename);
				carBase.setWordurl(realPath);
				carBase.setWordName(filename);
				carRepository.save(car);
				carBaseRepository.save(carBase);
				return JsonData.success(realPath, "文件上传成功");
			}
		} catch (Exception e) {
			throw new PermissionException("文件上传失败");
		}
		return JsonData.fail("文件不能为空");
	}

	// 文见下载
	@RequestMapping("/download.action")
	@ResponseBody
	public ResponseEntity<byte[]> downloadFile(String fileName, String filePath, HttpServletRequest request,
			HttpServletResponse response) throws IOException {

		File file = new File(filePath + File.separator + fileName);
		HttpHeaders headers = new HttpHeaders();
		String filename = new String(fileName.getBytes("UTF-8"), "iso-8859-1");
		headers.setContentDispositionFormData("attachment", filename);
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		byte[] fileToByteArray = FileUtils.readFileToByteArray(file);
		return new ResponseEntity<byte[]>(fileToByteArray, headers, HttpStatus.CREATED);
	}
	// 定时去读文件夹然后对文件进行删除
	
	
}
