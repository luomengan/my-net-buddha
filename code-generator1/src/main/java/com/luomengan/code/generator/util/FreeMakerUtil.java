package com.luomengan.code.generator.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class FreeMakerUtil {

	/**
	 * 
	 * 获取模板文件
	 * 
	 * @param name
	 * @return
	 */
	public static Template getTemplate(String dir, String name) {
		try {
			Configuration cfg = new Configuration();
			cfg.setClassForTemplateLoading(FreeMakerUtil.class, dir);
			Template template = cfg.getTemplate(name);
			return template;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 控制台输出
	 * 
	 * @param name
	 * @param root
	 */
	public static void print(String templateDir, String templateName, Map<String, Object> root) {
		try {
			Template template = getTemplate(templateDir, templateName);
			template.process(root, new PrintWriter(System.out));
		} catch (TemplateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * 生成文件
	 * 
	 * @param name:模板名
	 * @param root：数据原型
	 * @param outFile：输出路径(全路径名)
	 */
	public static void generateFile(String templateDir, String templateName, Map<String, Object> root,
			String outFilePath) {
		FileWriter out = null;
		try {
			// 通过一个文件输出流，就可以写到相应的文件中，此处用的是绝对路径
			out = new FileWriter(new File(outFilePath));
			Template temp = getTemplate(templateDir, templateName);
			temp.process(root, out);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (TemplateException e) {
			e.printStackTrace();
		} finally {
			try {
				if (out != null)
					out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 生成文件
	 * 
	 * @param name:模板名
	 * @param root：数据原型
	 * @param outFile：输出路径(全路径名)
	 */
	public static void generateFile(String templateDir, String templateName, Map<String, Object> root, File outFile) {
		FileWriter out = null;
		try {
			File parentFile = outFile.getParentFile();
			if (!parentFile.exists()) {
				parentFile.mkdirs();
			}
			// 通过一个文件输出流，就可以写到相应的文件中，此处用的是绝对路径
			out = new FileWriter(outFile);
			Template temp = getTemplate(templateDir, templateName);
			temp.process(root, out);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (TemplateException e) {
			e.printStackTrace();
		} finally {
			try {
				if (out != null)
					out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
