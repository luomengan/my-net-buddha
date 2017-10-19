<!-- list -->
<ul class="nav">
    <li class="hidden-folded padder m-t m-b-sm text-muted text-xs">
        <span translate="aside.nav.Navigation">Navigation</span>
    </li>
    <li class="line dk"></li>

    <li ui-sref-active="active">
        <a ui-sref="app.index">
            <i class="glyphicon glyphicon-home"></i>
            <span>首页</span>
        </a>
    </li>
    <li ui-sref-active="active">
        <a ui-sref="app.userInfo">
        	<i class="icon-user"></i> 
            <span>用户信息</span>
        </a>
    </li>
    <li ui-sref-active="active">
        <a ui-sref="app.chargeManage">
        	<i class="fa fa-money"></i> 
            <span>充值管理</span>
        </a>
    </li>
    <li ui-sref-active="active">
        <a ui-sref="app.orderManage">
        	<i class="fa fa-stack-exchange"></i> 
            <span>订单管理</span>
        </a>
    </li>
    
    <li ng-class="{active:$state.includes('app.basicAdmin')}" class="noactive">
		<a href class="auto"> 
			<span class="pull-right text-muted"> 
				<i class="fa fa-fw fa-angle-right text"></i> 
				<i class="fa fa-fw fa-angle-down text-active"></i>
			</span> 
			<i class="glyphicon glyphicon-list-alt icon"></i> 
			<span>基础数据管理</span>
		</a>
		<ul class="nav nav-sub dk">
		<#list dataObjectPojoList as being>
			<li ui-sref-active="active">
		        <a ui-sref="app.basicAdmin.${being.humpName}">
		        	<!--
		        	<i class="${being.manageIcon}"></i>
		        	--> 
		            <span>${being.description}_管理</span>
		        </a>
		    </li>
		</#list>
		</ul>
	</li>
    
</ul>
<!-- / list -->