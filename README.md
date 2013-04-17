DVD-rental-System
=================

Software Quality Project


You are to form a team of two or three people to design, implement, document
and deliver a two part software product. All phases to follow Extreme
Programming philosophy as much as it applies - in particular,
• continuously maintained test suites as requirements and quality control
• pair programming of all code
• simplest possible solution to every problem
• continuous redesign and rearchitecting
• automation in testing and integration
• frequent integration and complete releases

Every two weeks (or so, see the schedule below) you will deliver concrete
evidence of your team’s progress as required by project assignments.
Project Phases

The project will be done in six phases, each of which will be an assignment.
Phases will cover steps in the process of creating a quality software result in the
context of an Extreme Programming process model.
Assignments will be on the quality control aspects of requirements, rapid
prototyping, design, coding, integration and analysis of the product you are
building. Throughout the project, you should keep records of all evidence of your
product quality control steps and evolution, in order to make the marketing case
that you have a quality result at the end of the course.
Your final products will be tested and evaluated.
Project Schedule


The product you are to design and build is a DVD Rental System. The system
consists of two parts:
• the Front End, a point of rental terminal for simple DVD rental transactions
• the Back End, an overnight batch processor to maintain and update a
master DVD rental file
Both parts will be run as console applications, that is, they are to be invoked from
a command line and use text and text file input/output only (this is an important
requirement for assignments later in the project, so don’t ask for exceptions)
CSCI 3060U/ENGR 3980U Winter 2012 © 2012 J.S. Bradbury Page 3 of 11
The Front End
The Front End reads in a file of DVD titles and containing information on each
title including quantity of DVDs available (1), processes a stream of DVD rental
transactions one at a time (2), and writes out a file of DVD rental transactions at
the end of the session (3).
Informal Customer Requirements for the Front End
The Front End handles a sequence of transactions, each of which begins with a
single transaction code (word of text) on a separate line
The Front End must handle the following transaction codes:

login - start a Front End session

rent - rent a DVD

return - return a DVD

create - create a new DVD title with quantity (privileged transaction)

add - add more copies of a given DVD (privileged transaction)

remove - remove a DVD from circulation, cancel any outstanding requests (privileged transaction)

sell - change the status of a DVD title from rental to sale (privileged transaction)

buy - purchase DVDs

logout - end a Front End session

Transaction Code Details
login - start a Front End session
• should ask for the kind of session, which can be either:
o standard, which means DVD rental mode, or
o admin, which means privileged mode
• after the kind is accepted, reads in the current DVD file (see below)
and begins accepting transactions
• Constraints:
o no transaction other than login should be accepted before a
login
o no subsequent login should be accepted after a login, until
after a logout
o after a standard login, only unprivileged transactions are
accepted
o after an admin login, all transactions are accepted
logout - end a Front End session
• should write out the DVD transaction file (see below) and stop
accepting any transactions except login
• Constraints:
o should only be accepted when logged in
o no transaction other than login should be accepted after a
logout
create - create and allocate copies for a new DVD available for rental
• should ask for the new DVD title (as a text line)
• then should ask for the number of copies available for rental
• should save this information to the DVD transaction file
• Constraints:
o privileged transaction - only accepted when logged in in
admin mode
o new DVD name is limited to at most 25 characters
o new DVD name must be different from all other current
DVDs
o number of copies can be at most 999
o copies of this DVD should not be available for rental in this
session
add - add more copies for a given DVD title
• should ask for the DVD title (as a text line)


• then should ask for the number of copies to add to the DVD title
• should save this information for the DVD transaction file
• Constraints:
o privileged transaction - only accepted when logged in in
admin mode
o DVD name must be the name of a current DVD available for
rent
o added copies should not be available for rent in this session
remove - cancel any outstanding rental requests from this session and
delete the DVD
• should ask for the DVD title (as a text line)
• should save this information for the DVD transaction file
• Constraints:
o privileged transaction - only accepted when logged in in
admin mode
o DVD title must be the name of a current DVD
o no further transactions should be accepted on a deleted
DVD
rent - rent copies of a DVD
• should ask for the DVD title and number of copies
• should subtract the number of copies from the number of available
copies of the DVD
• should save this information for the DVD transaction file
• Constraints:
o DVD title must be a current DVD title with enough copies
available
o at most 3 copies of the same title can be rented in one rent
return - return a previously rented copy of a DVD
• should ask for the DVD title and number of copies
• should add the number of copies to the number of available copies
of the DVD
• should save this information for the DVD transaction file
• Constraints:
o DVD title must be a current DVD title
o at most 3 copies can be returned in one return transaction


sell - change the status of a DVD title from rental (R) to sale (S)
• should ask for the DVD title (as a text line)
• should ask for a sale price for the DVD in dollars (e.g. 15.00)
• should save this information to the DVD transaction file

• Constraints:
o privileged transaction - only accepted when logged in in admin mode
o DVD title must be the name of a current DVD
o the maximum price for a DVD sale is 150.00
o edit status only changes the status from rental to sale – it can not change the status back
o no further transactions should be accepted on a DVD with a new status In this session buy - buy copies of a DVD
• should ask for the DVD title and number of copies
• should display the cost per unit and the total cost to the user and ask for confirmation in the form of yes or no.
• should subtract the number of copies from the number of available copies of the DVD
• should save this information for the DVD transaction file

• Constraints:
o DVD title must be a current DVD title with enough copies available
o at most 5 copies can be purchased in one buy transaction
(no limit - all remaining copies - in privileged mode)
General Requirements for the Front End
The Front End should never crash or stop except as directed by transactions.
The Front End cannot depend on valid input - it must gracefully and politely
handle bad input of all kinds (note: but you can assume that input is at least lines
of text).


DVD Transaction File
At the end of each session, when the logout transaction is processed, a DVD
transaction file for the day is written, listing every transaction made in the
session.
Contains fixed-length (41 characters) text lines of the form:
Where:
CC
is a two digit transaction code, 01-rent, 02-return, 03-create,
04-add, 05-remove, 06-buy, 07-sell, 00-end of session
AAAAAAAAAAAAAAAAAAAAAAAAAAAAA
is the DVD title
NNN
is the number of copies in the transaction
S
is the status of the DVD, for rental (R) or for sale (S).
PPPPPP
is the price in Canadian dollars if the DVD status is sale
_
is a space
Constraints:
• every line is exactly 41 characters (plus newline)
• numeric fields are right justified, filled with zeroes (e.g., 0023 for 23
copies of a DVD)
• alphabetic fields are left justified, filled with spaces (e.g.

Star_Wars_______________ for DVD title Star Wars)

• unused numeric fields are filled with zeros (e.g., 0000)
• in a numeric field that is used to represent a monetary value, if the
value is only in dollars, then “.00” is appended to the end of the
value (e.g. 110.00 for 110)
• unused alphabetic fields are filled with spaces (blanks) 
(e.g., ________________________ )

• the sequence of transactions ends with an end of session (00)
transaction code

CC_AAAAAAAAAAAAAAAAAAAAAAAAA_NNN_S_PPPPPP


Current DVD File
Consists of fixed length (39 characters) text lines containing a DVD title and
number of copies available in the form:
where:
AAAAAAAAAAAAAAAAAAAAAAAAA
is the DVD title
NNNN
is the number of tickets in the transaction
S
is the status of the DVD, for rental (R) or for sale (S).
PPPPPP
is the price in Canadian dollars if the DVD status is sale
_
is a space
Constraints:
• every line is exactly 39 characters (plus newline)
• numeric fields are right justified, filled with zeroes (e.g., 0023 for 23
tickets)
• alphabetic fields are left justified, filled with spaces (e.g.
Star_Wars_______________ for DVD title Star Wars)
• unused numeric fields are filled with zeros (e.g., 0000)
• in a numeric field that is used to represent a monetary value, if the
value is only in dollars, then “.00” is appended to the end of the
value (e.g. 110.00 for 110)
• unused alphabetic fields are filled with spaces (blanks) (e.g.,
________________________ )
• file ends with a special DVD titled END with zero copies and the
status and price fields empty.
AAAAAAAAAAAAAAAAAAAAAAAAA_NNNN_S_PPPPPP


The Back End

The Back End reads in the previous day’s master DVD file and then applies all of
the DVD transactions from a merged set of DVD transaction files to the old
master DVD file to produce the new master DVD file. Because transactions may
also create or delete new DVD, it also produces a new current DVD file for
tomorrow’s Front End runs.

Informal Customer Requirements for the Back End
The Back End reads the Master DVD File (see below) and the Merged DVD
Transaction File (see below) and applies all transactions to the Old Master DVD
File to produce the New Master DVD File and the new Current DVD File.
The Back End enforces the following business constraints, and produces a failed
constraint log on the terminal as it processes transactions from the merged DVD
transaction file.

Constraints:
• no DVD should ever have a negative number of copies left
• a newly created DVD must have a title different from all existing DVDs General Requirements for the Back End
The Back End should assume correct input format on all files, and need not
check for bad input. However, if by chance it notices bad input, it should
immediately stop and log a fatal error on the terminal.
Back End Error Recording

All recorded errors should be of the form:
• For failed constraint errors, <msg> should contain the type and
description of the error and the transaction that caused it to occur.
ERROR: <msg>

• For fatal errors, <msg> should contain the type and description and the
file that caused the error.
The Master DVD File
The Master DVD File consists of fixed-length (50 characters) lines of the form:
where:
EEEEE
is the DVD number
NNNN
is the remaining number of copies available
TTTT
is the total number of copies
S
is the status of the DVD, for rental (R) or for sale (S).
PPPPPP
is the price in Canadian dollars if the DVD status is sale
AAAAAAAAAAAAAAAAAAAAAAAAA
is the DVD title
_
is a space
Constraints:
• every line is exactly 50 characters (plus newline)
• numeric fields are right justified, filled with zeroes (e.g., 0023 for 23
tickets)
• alphabetic fields are left justified, filled with spaces (e.g.
Star_Wars_______________ for DVD title Star Wars)
• unused numeric fields are filled with zeros (e.g., 0000)
• in a numeric field that is used to represent a monetary value, if the
value is only in dollars, then “.00” is appended to the end of the
value (e.g. 110.00 for 110)
• unused alphabetic fields are filled with spaces (blanks) (e.g.,
________________________ )
• the Master DVD File must always be kept in ascending order by
DVD id number
EEEEE_NNNN_TTTT_S_PPPPPP_AAAAAAAAAAAAAAAAAAAAAAAA

The Merged DVD Transaction File
The Merged DVD Transaction File is the concatenation of any number of DVD
transaction files output from Front Ends of the DVD, ended with an empty one
(one containing no real transactions, just a line with a 00 transaction code).
The Current DVD File
A file containing every current DVD title (in the New Master DVD File) and the
appropriate information as defined in the format described for the Front End.
