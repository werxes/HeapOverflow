<#import "parts/commonAsync.ftl" as c>
<@c.page>


<div class="row mt-3">
	<button type="button" class="btn btn-primary" onclick='window.history.back()'>Back</button>
</div>

<#if error?has_content>
	<div class="row mt-3">
		<div class="alert alert-danger" role="alert">
			${error}
		</div>
	</div>
<#else>
<div class="row">
	<div class="card my-3">
		<div class="card-header"><h4>Handling error</h4></div>
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
			<#list websitesOne as websiteOne>
				<tr>
					<th>${websiteOne.id}</th>
					<td>${websiteOne.title}</td>
					<td>${websiteOne.description}</td>
				</tr>
			<#else>
				No website
			</#list>
		</tbody>
		</table>
		</div>
	</div>
</div>
</#if>





</@c.page>