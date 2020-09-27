package com.winAndCloud.utils;

import java.util.HashMap;
import java.util.Map;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.TemplateConfig;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

/**
 *
 * @ClassName: CodeGeneration
 * @Description: 代码生成器
 */
public class CodeGeneration {

	public static void main(String[] args) {
		// 全局配置
		GlobalConfig gc = getGlobalConfig();

		// 数据源配置
		DataSourceConfig dsc = getDataSourceConfig();

		// 策略配置
		StrategyConfig strategy = getStrategyConfig();

		// 包配置:设置模块名(需要手动填写)!
		PackageConfig pc = getPackageConfig("模块名");

		// 自定义属性注入
		InjectionConfig injectionConfig = getInjectionConfig();

		// 自定义代码模板
		TemplateConfig templateConfig = getTemplateConfig();

		// 执行生成
		atuoGenerator(gc, dsc, strategy, pc, injectionConfig, templateConfig);

	}

	/**
	 * @description: 执行生成
	 * @param gc
	 *            全局配置
	 * @param dsc
	 *            数据源配置
	 * @param strategy
	 *            策略配置
	 * @param pc
	 *            包配置
	 * @param injectionConfig
	 *            自定义属性注入
	 * @param templateConfig
	 *            自定义代码模板
	 */
	private static void atuoGenerator(GlobalConfig gc, DataSourceConfig dsc, StrategyConfig strategy, PackageConfig pc,
			InjectionConfig injectionConfig, TemplateConfig templateConfig) {
		AutoGenerator mpg = new AutoGenerator();
		mpg.setGlobalConfig(gc);
		mpg.setDataSource(dsc);
		mpg.setStrategy(strategy);
		mpg.setTemplateEngine(new FreemarkerTemplateEngine());
		mpg.setPackageInfo(pc);
		mpg.setCfg(injectionConfig);
		mpg.setTemplate(templateConfig);
		mpg.execute();
	}

	/**
	 * @description: 自定义代码模板
	 * @return:(返回值说明)
	 */
	private static TemplateConfig getTemplateConfig() {
		// 指定自定义模板路径, 位置：/resources/templates/entity2.java.ftl(或者是.vm)
		TemplateConfig templateConfig = new TemplateConfig().setEntity("templates/entity2.java");
		templateConfig.setXml("templates/mapper.xml");
		return templateConfig;
	}

	/**
	 * @description: 自定义属性注入
	 * @return:(返回值说明)
	 */
	private static InjectionConfig getInjectionConfig() {
		// 自定义属性注入:abc
		InjectionConfig injectionConfig = new InjectionConfig() {
			// 在.ftl(或者是.vm)模板中，通过${cfg.abc}获取属性
			@Override
			public void initMap() {
				Map<String, Object> map = new HashMap<>();
				map.put("abc", this.getConfig().getGlobalConfig().getAuthor() + "-mp");
				this.setMap(map);
			}
		};
		return injectionConfig;
	}

	/**
	 * @description: 包配置
	 * @return:(返回值说明)
	 */
	private static PackageConfig getPackageConfig(String moulde) {
		PackageConfig pc = new PackageConfig();
		// 需要生成的表
		pc.setParent("com.iflytek.server");
		pc.setController("web." + moulde);
		pc.setService("service." + moulde);
		pc.setServiceImpl("service." + moulde + ".impl");
		pc.setMapper("mapper." + moulde);
		pc.setEntity("entity.po." + moulde);
		pc.setXml("xml." + moulde);
		return pc;
	}

	/**
	 * @description: 策略配置
	 * @return:(返回值说明)
	 */
	private static StrategyConfig getStrategyConfig() {
		StrategyConfig strategy = new StrategyConfig();
		strategy.setTablePrefix(new String[] { "easybuy_" });// 此处可以修改为您的表前缀
		strategy.setNaming(NamingStrategy.underline_to_camel);// 表名生成策略
		strategy.setColumnNaming(NamingStrategy.underline_to_camel);// 列名生成策略
		strategy.setInclude(new String[] { "easybuy_user" }); // 需要生成的表名，多个用逗号分隔
		strategy.setSuperServiceClass(null);
		strategy.setSuperServiceImplClass(null);
		strategy.setSuperMapperClass(null);
		strategy.setRestControllerStyle(true);
		strategy.setEntityLombokModel(true);// 是否使用Lombok简化代码
		strategy.setSuperEntityColumns("is_enable", "remark", "creator", "created_date", "modifier", "last_updated_date", "update_control_id");
		return strategy;
	}

	/**
	 * @description: 数据源配置
	 * @return:(返回值说明)
	 */
	private static DataSourceConfig getDataSourceConfig() {
		DataSourceConfig dsc = new DataSourceConfig();
		dsc.setDbType(DbType.MYSQL);
		dsc.setDriverName("com.mysql.cj.jdbc.Driver");
		dsc.setUsername("root");
		dsc.setPassword("sa123");
		dsc.setUrl("jdbc:mysql://localhost:3306/shoppgo?characterEncoding=utf-8&serverTimezone=UTC&useSSL=false");

		dsc.setTypeConvert(new MySqlTypeConvert() {
			// 自定义数据库表字段类型转换【可选】
			@Override
			public DbColumnType processTypeConvert(GlobalConfig globalConfig, String fieldType) {
				System.out.println("自动检测到数据库类型：" + fieldType);
				// 金额或者敏感数值单位需要精确
				if (fieldType.toLowerCase().contains("datetime")) {// 含有这种格式的识别为金额类型
					return DbColumnType.DATE;
					// 编码枚举数值类型或者布尔类型使用整形表示
				} else if (fieldType.contains("decimal")) {
					return DbColumnType.FLOAT;
				} else {
					// 使用默认的
					return (DbColumnType) super.processTypeConvert(globalConfig, fieldType);
				}
			}
		});
		return dsc;
	}

	/**
	 * @description: 全局配置
	 * @return:(返回值说明)
	 */
	private static GlobalConfig getGlobalConfig() {
		GlobalConfig gc = new GlobalConfig();
		String path = CodeGeneration.class.getClassLoader().getResource("").getPath();
		int index = path.indexOf("target/classes/");
		String paths = path.substring(1, index) + "src/main/java/";
		// String paths = "D://test";
		gc.setOutputDir(paths);// 输出文件路径
		gc.setFileOverride(true);// 是否文件覆盖，如果多次
		gc.setActiveRecord(false);// 不需要ActiveRecord特性的请改为false
		gc.setEnableCache(false);// XML 二级缓存
		gc.setBaseResultMap(true);// XML ResultMap
		gc.setBaseColumnList(true);// XML columList
		gc.setAuthor("xiongfeng");// 作者
		gc.setControllerName("%sController");// 自定义文件命名，注意 %s 会自动填充表实体属性！
		gc.setServiceName("%sService");
		gc.setServiceImplName("%sServiceImpl");
		gc.setMapperName("%sMapper");
		gc.setXmlName("%sMapper");
		gc.setSwagger2(true);
		gc.setIdType(IdType.UUID);
		return gc;
	}

}