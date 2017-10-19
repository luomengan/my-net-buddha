package ${basePackage}.entity;

<#assign isContainDate="false"/>
<#list dataColumnPojoList as being>
	<#if being.type = "Date">
		<#assign isContainDate="true"/>
	</#if>
</#list>
<#if isContainDate == "true">
import java.util.Date;

</#if>
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * ${dataObjectPojo.description} 实体
 * 
 * @author luomengan
 *
 */
@Entity
@Table(name = "t${dataObjectPojo.dbTableName}")
public class ${dataObjectPojo.name} {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	<#list dataColumnPojoList as being>
	/**
	 * ${being.description}
	 */
	<#if being.type == "Varchar">
	private String ${being.name};
	</#if>
	<#if being.type == "Integer">
	private Integer ${being.name};
	</#if>
	<#if being.type == "Long">
	private Long ${being.name};
	</#if>
	<#if being.type == "Double">
	private Double ${being.name};
	</#if>
	<#if being.type == "Boolean">
	private Boolean ${being.name};
	</#if>
	<#if being.type == "Date">
	private Date ${being.name};
	</#if>
	</#list>

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	<#list dataColumnPojoList as being>
	<#if being.type == "Varchar">
		<#assign columnType="String"/>
	</#if>
	<#if being.type == "Integer">
		<#assign columnType="Integer"/>
	</#if>
	<#if being.type == "Long">
		<#assign columnType="Long"/>
	</#if>
	<#if being.type == "Double">
		<#assign columnType="Double"/>
	</#if>
	<#if being.type == "Boolean">
		<#assign columnType="Boolean"/>
	</#if>
	<#if being.type == "Date">
		<#assign columnType="Date"/>
	</#if>
	public ${columnType} get${being.upName}() {
		return ${being.name};
	}
	
	public void set${being.upName}(${columnType} ${being.name}) {
		this.${being.name} = ${being.name};
	}
	
	</#list>
}
