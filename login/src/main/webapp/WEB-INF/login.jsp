<form action="/login" method="post">
	<div>
		Username: <input type="text" name="userName" value="">
	</div>
	<div>
		Password:<input type="text" name="password" value="">
	</div>
	<div>
		<input type="submit" value="Login">
	</div>
	<div>
		<input type="button" value="Register" onClick="goToRegister()">
	</div>
</form>
<script>
	function goToRegister() {
		window.location.href="/register";
	}
</script>