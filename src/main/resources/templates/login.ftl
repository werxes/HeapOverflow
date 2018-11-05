<#import "parts/common.ftl" as c>
<@c.page>

<div class="card">
  <div class="card-header">
    Login
  </div>
  <div class="card-body">
    



<form action="/login" method="post">

	<#if logout>
		<div class="form-group row">		
			<div class="alert alert-success" role="alert">You have been logout.</div>
		</div>
	</#if>
	
	<#if error>
		<div class="form-group row">
			<div class="alert alert-danger" role="alert">Bad Credentials</div>
		</div>
	</#if>

    <div class="form-group row">
        <label class="col-sm-2 col-form-label">User Name :</label>
        <div class="col-sm-6">
            <input type="text" name="username"
                   class="form-control"
                   placeholder="User name" />
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label">Password:</label>
        <div class="col-sm-6">
            <input type="password" name="password"
                   class="form-control"
                   placeholder="Password" />
        </div>
    </div>
    <input type="hidden" name="_csrf" value="${_csrf.token}" />
    <button type="submit" class="btn btn-primary">Submit</button>
</form>

	
	
	
  </div>
</div>


</@c.page>