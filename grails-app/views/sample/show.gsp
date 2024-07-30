<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'sample.label', default: 'Sample')}" />
        <title><g:message code="default.show.label" args="[entityName]" /></title>
    </head>
    <body>
    <div id="content" role="main">
        <nav class="container">
            <section class="row">
                <a href="#show-sample" class="visually-hidden-focusable" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
                <nav class="navbar navbar-expand-lg bg-body-tertiary">
                    <ul class="navbar-nav container-fluid">
                        <li class="nav-item"><a class="nav-link btn" aria-label="Home" href="${createLink(uri: '/')}">
                            <i class="bi-house"></i> <g:message code="default.home.label"/></a>
                        </li>
                        <li class="nav-item"><g:link class="nav-link btn" aria-label="List" action="index">
                            <i class="bi-database"></i> <g:message code="default.list.label" args="[entityName]" /></g:link>
                        </li>
                        <li class="nav-item me-auto">
                            <g:link class="nav-link btn" aria-label="List" action="create"><i class="bi-database-add"></i> <g:message code="default.new.label" args="[entityName]" /></g:link>
                        </li>
                    </ul>
                </nav>
            </section>
            <section class="row">
                <div id="show-sample" class="col-12 content scaffold-show" role="main">
                    <h1><g:message code="default.show.label" args="[entityName]" /></h1>
                    <g:if test="${flash.message}">
                    <div class="message" role="status">${flash.message}</div>
                    </g:if>
                    <f:display bean="sample" />
                    <g:form resource="${this.sample}" method="DELETE">
                        <fieldset class="bg-body-tertiary">
                            <g:link class="btn btn-outline-primary" action="edit" resource="${this.sample}">
                                <i class="bi-pencil-square"></i> <g:message code="default.button.edit.label" default="Edit" />
                            </g:link>
                            <button class="btn btn-outline-primary" type="submit" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');">
                                <i class="bi-trash"></i> ${message(code: 'default.button.delete.label', default: 'Delete')}
                            </button>
                        </fieldset>
                    </g:form>
                </div>
            </section>
        </div>
    </div>
    </body>
</html>
