UB CONQUEST GAME MANUAL




To begin the game, you must use the Terminal command as follows:
	java -jar CollegeConquest-u.jar Chris Dom Pat Rafael
Where the names at the end of the command are the names of the players who will be playing the game.


The objective of UB Conquest is to become President of the University. This is done by becoming the Dean of all six Schools. In order to become Dean of a School, one must become Chair of all four Departments in that School. The "conquest" aspect of the game is handled by Elections (discussed later in Manual).

Schools (with their Departments listed below): 
Arts:			Sciences:		Humanities:		Engineering:	Law:			Medicine:
Music			Biology			History			Computer		Business		Anesthesia
Theatre			Chemistry		Linguistics		Electrical		Family			Otolaryngology
Dance			Physics			Literature		Mechanical		Criminal		Pathology
Visual Arts		Mathematics		Religion		Civil			Immigration		Pediatrics

Each Department is adjacent to the other Departments in it's School.
Other adjacencies (these are indicated by colored borders): 
	- Music <> Physics
	- Visual Arts <> Mechanical
	- Linguistics <> Computer
	- Religion <> Mathematics
	- Chemistry <> Anesthesia
	- Civil <> Business
	- Criminal <> Pathology

At the start of the game, each Player will be assigned Chair of a random Department.

There are three phases to each turn:
	- Place Students: at the start each turn, the current player will receive a variable amount (depending on the number of Departments the player is Chair of and the number of Schools a player is Dean of) of students to place in any of the Departments that belong to this player. A player may not place these students in any Department in which they are not the Chair. In order to place these students, drag the black hat icon to the Department where you would like the student to be placed.
		< for each Department for which a player is Chair: +3 students per turn
		< for each Department for which a player is also Dean of that Department's School: +5 students per turn
		< for each School for which a player is Dean: +10 students per turn

	- Student Movement: once all new students have been placed, a player may also move any students that are loyal to him/her to any adjacent Department, even if the player is not Chair of the new Department. Students that are moved remain loyal to their player. In order to move a student, drag the "?" icon from the Department where the student is located to the new Department. Once a player is done moving (or not moving) students to new Departments, the player may proceed to the next phase.

	- Elections: a player may call an Election (press the impossible-to-miss Call Election button, and then enter the name of the Department in which you would like to call an election) in any Department in which they have at least one student loyal to them. You may only call an election in a given Department once per turn. When an election is called, each student in the Department "votes". They vote for secession to the new Chair with probability .66 if they are loyal to the election-caller, and .34 if they are not. If a player wins an election, all of the students in the Department become loyal to that player, and the player becomes Chair of the Department. Once a player is done calling elections, he/she may end their turn.

You may hover over the Department names or the "?" logos in the Departments for more information on Students in the Departments as well as who is the chair of the Department. The number of students shown is the number of movable students that are loyal to you.

Note: the Current Player's Chairs are represented by the names of those Departments being highlighted green (there is also a list of Current Player's Chairs to the right of the screen), and the Chairs of other players are represented by red.

If at any point a player is the Chair of zero Departments, that player is eliminated from the game.
When a player becomes Chair of all four Departments in a School, he/she becomes Dean of that School.
When a player becomes Dean of all six Schools, he/she becomes President of the University and wins the game!
