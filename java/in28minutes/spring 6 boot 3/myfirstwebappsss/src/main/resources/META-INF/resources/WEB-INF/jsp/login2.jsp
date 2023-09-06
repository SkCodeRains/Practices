<%@ include file="common/header.jsp" %>
    <%@ include file="common/navigation.jsp" %>
	<style>
		.form{
			color: white  !important;
			background-color: #00000030 !important;
			box-shadow: inset 0px 0px 10px 1px black, inset 0px -10px 18px 0px white;
		}
	</style>
<div class="w-100 h-100 d-flex bg-transparent text-white   align-items-center  justify-content-center ">
	<div class="container bg-transparent right-panel-active">
		<!-- Sign Up -->
		<!-- 			<div class="container__form container--signup">
			<form action="#" class="form" id="form1">
				<h2 class="form__title">Sign Up ${name}</h2>
				<input type="text" placeholder="User" class="input" />
				<input type="email" placeholder="Email" class="input" />
				<input type="password" placeholder="Password" class="input" />
				<button class="btn">Sign Up</button>
			</form>
		</div> -->

		<!-- Sign In -->
		<div class="container__form  bg-transparent container--signin">
			${error}
			<form 	class="form" id="form2" method="post">
				<h2 class="form__title">Sign In</h2>
				<input type="text" name="name" placeholder="name" class="input" />
				<input type="password" name="password" placeholder="Password" class="input" /> 
				<a href="#" class="link text-white ">Forgot your password?</a>
				<button type="submit" class="btn login">Sign In</button>
			</form>
		</div>

		<!-- Overlay -->
<!-- <div class="container__overlay">
			<div class="overlay">
				<div class="overlay__panel overlay--left">
					<button class="btn" id="signIn">Sign In</button>
				</div>
				<div class="overlay__panel overlay--right">
					<button class="btn" id="signUp">Sign Up</button>
				</div>
			</div>
		</div> -->
	</div>
</div>
		<script type="text/javascript">
			/* 		const signInBtn = document.getElementById("signIn");
			const signUpBtn = document.getElementById("signUp");
			const fistForm = document.getElementById("form1");
			const secondForm = document.getElementById("form2");
			const container = document.querySelector(".container");
			
				signInBtn.addEventListener("click", () => {
					container.classList.remove("right-panel-active");
				});
		
				signUpBtn.addEventListener("click", () => {
					container.classList.add("right-panel-active");
				}); */
				
				// fistForm.addEventListener("submit", (e) => e.preventDefault());
		// secondForm.addEventListener("submit", (e) => e.preventDefault());

	</script>
				<%@ include file="common/footer.jsp" %>