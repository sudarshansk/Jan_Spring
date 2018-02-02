<html>
	<body>
		<h1>Welcome to the Guessing Game. Enter a number between 1 and 100</h1>
		<form action="/play" method="post">
			<input type="text" name="guess" placeholder="Enter a number"/><br/>
			<button>Play</button>
		</form>
		<h2>${game.getMessage() == null ? "": game.getMessage()}</h2>
		<h3>Attempts: ${game.getAttempts()}</h3>
	</body>
</html>