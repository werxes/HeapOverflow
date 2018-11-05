<#import "parts/common.ftl" as c>
<@c.page>

Hello ${username}
<br>
<div class="card">
  <div class="card-header">
    Featured
  </div>
  <div class="card-body">
    <table class="table">
	  <thead>
	    <tr>
	      <th scope="col">Id</th>
	      <th scope="col">Title</th>
	      <th scope="col">Description</th>
	    </tr>
	  </thead>
	  <tbody>
	    <tr ng-repeat="item in websites">
	      <th>{{item.id}}</th>
	      <td>{{item.title}}</td>
	      <td>{{item.description}}</td>
	    </tr>
	  </tbody>
	</table>
  </div>
</div>

<br>

<form action="/logout" method="post">
	<input type="submit" value="Logout"/>
    <input type="hidden" name="_csrf" value="${_csrf.token}" />
</form>




</@c.page>