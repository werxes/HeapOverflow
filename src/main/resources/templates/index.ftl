<#import "parts/common.ftl" as c>
<@c.page>


<br>

<div class="card">
  <div class="card-header">
    Hello ${username}
  </div>
  <div class="card-body">


    <div class="list-group">

  		<a href="/angular" class="list-group-item list-group-item-action flex-column align-items-start">
    		<div class="d-flex w-100 justify-content-between">
      		<h5 class="mb-1">Angular</h5>
    		</div>
  	  	<p class="mb-1">Get data using AngularJS.</p>
	  	</a>

			<a href="/async" class="list-group-item list-group-item-action flex-column align-items-start">
    		<div class="d-flex w-100 justify-content-between">
      		<h5 class="mb-1">Async</h5>
    		</div>
  	  	<p class="mb-1">Get multiple REST services in asyncronius.</p>
	  	</a>

			<a href="/handleerror" class="list-group-item list-group-item-action flex-column align-items-start">
    		<div class="d-flex w-100 justify-content-between">
      		<h5 class="mb-1">Handle Error</h5>
    		</div>
  	  	<p class="mb-1">Get data from Service Handlig error.</p>
	  	</a>



	</div>


  </div>
</div>


<br>

<form action="/logout" method="post">
		<button type="submit" class="btn btn-info">Logout</button>
    <input type="hidden" name="_csrf" value="${_csrf.token}" />
</form>




</@c.page>