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
    
    <#list dataObjectPojoList as being>
		<li ui-sref-active="active">
	        <a ui-sref="app.${being.humpName}">
	        	<i class="glyphicon glyphicon-list-alt icon"></i> 
	            <span>${being.description}_管理</span>
	        </a>
	    </li>
	</#list>
    
</ul>
<!-- / list -->