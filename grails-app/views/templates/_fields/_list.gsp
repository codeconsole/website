<ol class="container ${domainClass.decapitalizedName}">
    <g:each in="${domainProperties}" var="p">
        <li class="row mb-3">
            <span id="${p.name}-label" class="form-label col-sm-3 text-sm-end"><g:message code="${domainClass.decapitalizedName}.${p.name}.label" default="${p.defaultLabel}" /></span>
            <div class="col-sm-9" aria-labelledby="${p.name}-label">${body(p)}</div>
        </li>
    </g:each>
</ol>