<div class="modal-body wrapper-lg">
    <div class="row">
        <div class="col-sm-12">
            <form name="${dataObjectPojo.humpName}EditForm" class="form-horizontal form-validation">
                <input type="hidden" ng-model="${dataObjectPojo.humpName}.id" />
                <div class="panel panel-default">
                    <div class="panel-heading">
                      <strong>修改${dataObjectPojo.description}</strong>
                    </div>
                    <div class="panel-body pb0">
                    	<#list dataColumnPojoList as being>
                    	<#assign isPassword="false"/>
                    	<#assign ngPattern=""/>
                    	<#assign placeholderText=""/>
                    	<#if being.name?index_of("password")!=-1>
							<#assign isPassword="true"/>
						</#if>
						<#if being.name?index_of("Password")!=-1>
							<#assign isPassword="true"/>
						</#if>
                    	<#if being.type == "Varchar">
							<#assign inputType="text"/>
							<#if isPassword == "true">
								<#assign inputType="password"/>
							</#if>
							<div class="form-group">
	                            <label class="col-sm-3 control-label">${being.description}：</label>
	                            <div class="col-sm-9">
	                                <input ng-model="${dataObjectPojo.humpName}.${being.name}" type="${inputType}" ${ngPattern!} placeholder="${placeholderText!}" class="form-control" required />    
	                            </div>
	                        </div>
	                        <div class="line line-dashed b-b pull-in"></div>
						</#if>
						<#if being.type == "Integer">
							<#assign inputType="number"/>
							<#if isPassword == "true">
								<#assign inputType="password"/>
							</#if>
							<div class="form-group">
	                            <label class="col-sm-3 control-label">${being.description}：</label>
	                            <div class="col-sm-9">
	                                <input ng-model="${dataObjectPojo.humpName}.${being.name}" type="${inputType}" ${ngPattern!} placeholder="${placeholderText!}" class="form-control" required />    
	                            </div>
	                        </div>
	                        <div class="line line-dashed b-b pull-in"></div>
						</#if>
						<#if being.type == "Long">
							<#assign inputType="number"/>
							<#if isPassword == "true">
								<#assign inputType="password"/>
							</#if>
							<div class="form-group">
	                            <label class="col-sm-3 control-label">${being.description}：</label>
	                            <div class="col-sm-9">
	                                <input ng-model="${dataObjectPojo.humpName}.${being.name}" type="${inputType}" ${ngPattern!} placeholder="${placeholderText!}" class="form-control" required />    
	                            </div>
	                        </div>
	                        <div class="line line-dashed b-b pull-in"></div>
						</#if>
						<#if being.type == "Double">
							<#assign inputType="text"/>
							<#if isPassword == "true">
								<#assign inputType="password"/>
							</#if>
							<div class="form-group">
	                            <label class="col-sm-3 control-label">${being.description}：</label>
	                            <div class="col-sm-9">
	                                <input ng-model="${dataObjectPojo.humpName}.${being.name}" type="${inputType}" ${ngPattern!} placeholder="${placeholderText!}" class="form-control" required />    
	                            </div>
	                        </div>
	                        <div class="line line-dashed b-b pull-in"></div>
						</#if>
						<#if being.type == "Boolean">
							<#assign inputType="text"/>
							<#if isPassword == "true">
								<#assign inputType="password"/>
							</#if>
							<div class="form-group">
	                            <label class="col-sm-3 control-label">${being.description}：</label>
	                            <div class="col-sm-9">
	                            	<input ng-model="${dataObjectPojo.humpName}.${being.name}" type="radio" ng-value="true">是&nbsp;&nbsp;
									<input ng-model="${dataObjectPojo.humpName}.${being.name}" type="radio" ng-value="false">否
	                            </div>
	                        </div>
	                        <div class="line line-dashed b-b pull-in"></div>
						</#if>
						<#if being.type == "Date">
							<#assign inputType="text"/>
							<#if isPassword == "true">
								<#assign inputType="password"/>
							</#if>
							<#assign placeholderText="日期格式为：yyyy-MM-dd HH:mm:ss"/>
							<#assign ngPattern='ng-pattern="/^[0-9]{4}-[0-9]{2}-[0-9]{2} [0-9]{2}:[0-9]{2}:[0-9]{2}$/"'/>
							<div class="form-group">
	                            <label class="col-sm-3 control-label">${being.description}：</label>
	                            <div class="col-sm-9">
	                                <input ng-model="${dataObjectPojo.humpName}.${being.name}" type="${inputType}" ${ngPattern!} placeholder="${placeholderText!}" class="form-control" required />    
	                            </div>
	                        </div>
	                        <div class="line line-dashed b-b pull-in"></div>
						</#if>
						</#list>
                    </div>
                    <footer class="panel-footer text-right">
                        <button ng-click="request${dataObjectPojo.name}Edit(${dataObjectPojo.humpName}EditForm.$valid);" type="submit" class="btn btn-success">保存</button>
                    </footer>
                </div>
            </form>
        </div>
    </div>
</div>