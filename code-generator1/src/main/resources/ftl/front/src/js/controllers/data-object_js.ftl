/********************* ${dataObjectPojo.description} Controller ************************/
angular.module('${dataObjectPojo.humpName}Admin', [])
    .controller('${dataObjectPojo.humpName}AdminController', ${dataObjectPojo.humpName}AdminControllerFn)
    .controller('${dataObjectPojo.humpName}AddController', ${dataObjectPojo.humpName}AddControllerFn)
    .controller('${dataObjectPojo.humpName}EditController', ${dataObjectPojo.humpName}EditControllerFn);

function ${dataObjectPojo.humpName}AdminControllerFn($scope, $modal, toaster, $http, tokenService) {
    $scope.${dataObjectPojo.humpName}Columns = [
        { data: null, defaultContent: '', className: 'select-checkbox', width: 15},
        { data: 'id', title: '主键' }
        <#list dataColumnPojoList as being>
        <#if being.isDisplayInTable>
        ,{ data: '${being.name}', title: '${being.description}' }
        </#if>
		</#list>
    ]

    // 添加按钮
    $scope.do${dataObjectPojo.name}Add = function() {
        $modal.open({
            templateUrl: '${dataObjectPojo.humpName}_add.html',
            controller: '${dataObjectPojo.humpName}AddController',
            size: 'md'
        });
    }
    // 修改按钮
    $scope.do${dataObjectPojo.name}Edit = function() {
        $modal.open({
            templateUrl: '${dataObjectPojo.humpName}_edit.html',
            controller: '${dataObjectPojo.humpName}EditController',
            size: 'md'
        });
    }

    // 删除按钮
    $scope.do${dataObjectPojo.name}Remove = function() {
        // 获取已选择的行id
        $scope.selectDataIds = [];
        var dtObj = $('#${dataObjectPojo.humpName}AdminTable').dataTable();
        var nTrs = dtObj.fnGetNodes();
        var ids = "";
        for(var i = 0; i < nTrs.length; i++) {
            if(jQuery(nTrs[i]).hasClass('selected')) {
                $scope.selectDataIds.push(dtObj.fnGetData(nTrs[i]).id);
                ids += dtObj.fnGetData(nTrs[i]).id + ",";
            }
        }

		if($scope.selectDataIds.length > 0) {
			ids = ids.substring(0, ids.length-1);
		}
        swal({
            title: "确定删除吗?",
            text: "确定删除后数据不可恢复!",
            type: "warning",
            showCancelButton: true,
            confirmButtonColor: "#DD6B55",
            confirmButtonText: "确定",
            cancelButtonText: "取消",
            closeOnConfirm: true
        }, function() {
            // 请求删除${dataObjectPojo.description}
            $http({
                method: 'post',
                url: '/${projectName}/${dataObjectPojo.humpName}/deletes',
                headers: {
                	'Content-Type': 'application/x-www-form-urlencoded' 
                },
                data: jQuery.param({ids: ids})
            }).then(function(response) {
                if(response.data.code === "200") {
                	$('#${dataObjectPojo.humpName}AdminTable').dataTable().api().ajax.reload();
                    toaster.pop('success', '', '删除${dataObjectPojo.description}成功！');
                } else {
					toaster.pop('error', '', '删除${dataObjectPojo.description}失败：' + response.data.exception.message + "!");                    
                }
                $('#${dataObjectPojo.humpName}AdminTable_wrapper').find(".btn-table-edit").attr("disabled", "disabled");
                $('#${dataObjectPojo.humpName}AdminTable_wrapper').find(".btn-table-remove").attr("disabled", "disabled");
            }, function(response) {
                tokenService.handleHttpFailed(response);
            });
        });
    }
}

function ${dataObjectPojo.humpName}AddControllerFn($scope, $modalInstance, toaster, $http, tokenService) {
    $scope.${dataObjectPojo.humpName} = {};
    
    <#list dataColumnPojoList as being>
	<#if being.type == "Boolean">
	$scope.${dataObjectPojo.humpName}.${being.name} = "false";
	</#if>
	</#list>
    
    // 请求添加
    $scope.request${dataObjectPojo.name}Add = function(isValid) {
        if(isValid) {
            // 请求添加${dataObjectPojo.description}
            $http({
                method: 'post',
                url: '/${projectName}/${dataObjectPojo.humpName}/',
                headers: {
                	'Content-Type': 'application/x-www-form-urlencoded' 
                },
                data: jQuery.param($scope.${dataObjectPojo.humpName})
            }).then(function(response) {
                if(response.data.code === "200") {
                    $('#${dataObjectPojo.humpName}AdminTable').dataTable().api().ajax.reload();
                    $modalInstance.close();
                    toaster.pop('success', '', '添加${dataObjectPojo.description}成功！');
                } else {
					toaster.pop('error', '', '添加${dataObjectPojo.description}失败：' + response.data.exception.message + "!");                    
                }
            }, function(response) {
                tokenService.handleHttpFailed(response);
            });
        }
    }
}

function ${dataObjectPojo.humpName}EditControllerFn($scope, $modalInstance, toaster, $http, tokenService) {
    $scope.${dataObjectPojo.humpName} = {};
    // 获取已选择的行
    var selectData = null;
    var dtObj = $('#${dataObjectPojo.humpName}AdminTable').dataTable();
    var nTrs = dtObj.fnGetNodes();
    for(var i = 0; i < nTrs.length; i++) {
        if(jQuery(nTrs[i]).hasClass('selected')) {
            selectData = dtObj.fnGetData(nTrs[i]);
        }
    }
    if(selectData) {
        jQuery.extend($scope.${dataObjectPojo.humpName}, selectData);
    }
    // 请求修改
    $scope.request${dataObjectPojo.name}Edit = function(isValid) {
        if(isValid) {
            // 请求修改${dataObjectPojo.description}
            $http({
                method: 'put',
                url: '/${projectName}/${dataObjectPojo.humpName}/',
                headers: {
                	'Content-Type': 'application/x-www-form-urlencoded' 
                },
                data: jQuery.param($scope.${dataObjectPojo.humpName})
            }).then(function(response) {
                if(response.data.code === "200") {
                	$('#${dataObjectPojo.humpName}AdminTable').dataTable().api().ajax.reload();
                    $modalInstance.close();
                    toaster.pop('success', '', '修改${dataObjectPojo.description}成功！');
                } else {
                    toaster.pop('error', '', '修改${dataObjectPojo.description}失败：' + response.data.message + "!");
                }
                $('#${dataObjectPojo.humpName}AdminTable_wrapper').find(".btn-table-edit").attr("disabled", "disabled");
                $('#${dataObjectPojo.humpName}AdminTable_wrapper').find(".btn-table-remove").attr("disabled", "disabled");
            }, function(response) {
                tokenService.handleHttpFailed(response);
            });
        }
    }
}