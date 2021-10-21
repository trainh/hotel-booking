# LAB 321Assignment
###### Type:      Long Assignment
###### Code:      J3.L.P0021
###### Point:     550
###### Slot(s):   NA

## Title: Hotel Booking
## Background
Build a website to service booking hotel online.
## Program Specifications
In this assignment, you are requested to develop a booking website. You must use Servlet as Controller and follow MVC2 model.
## Features:
This system contains the following functions:
<ul>
<li>Function 1: Login – 50 LOC
<ul>
<li>If the user has not authenticated, the system redirects to the registration page.</li>
<li>The actor enters userID and password, the function checks if the userID with the password is in the</li>
<li>The actor enters userID and password, the function checks if the userID with the password is in the
available user list, then grant the access permission. If not, a message would appear no notify that user is
not found.</li>
<li>Login function is required for shopping.</li>
</ul>
</li>
  
![login_page](https://github.com/traitrantruon/hotel-booking/blob/main/image/login-page.png)
  
<li>Function 2: Display- Search – 50 LOC
<ul>
<li>List all hotel which has an available room in the system.</li>
<li>Each hotel has some kind of room: single, double, family, …</li>
<li>Each room type has different price.</li>
<li>User can find the room based on hotel name or hotel area and check in date and check out date and
amount of room.</li>
<li>All users can use this function (login is not required).</li>
</ul>
</li>
  
![regis_page](https://github.com/traitrantruon/hotel-booking/blob/main/image/index-page.png)
  
<li>Function 3: Registration – 50 LOC
<ul>
<li>Register new user: email as ID, phone, name, address, create date</li>
<li>Create date is current date.</li>
<li>The default status of new user is active.</li>
<li>Password must be encrypted using SHA-256 before store in database.</li>
<li>Indented item</li>
</ul>
</li>

![regispage_page](https://github.com/traitrantruon/hotel-booking/blob/main/image/register-page.png)
  
<li>Function 4: Booking – 150 LOC
<ul>
<li>All users can use this function except admin role (login is required)</li>
<li>Add the selected room to booking cart</li>
<li>Each user can book any available room in the list (not limit the amount room want to book)</li>
<li>User can view the selected room in the cart. For each room: hotel name, room type, amount, price,
total. The screen must show the total amount of money of this cart.</li>
<li>User can remove the room from the cart. The confirm message will show before delete action.</li>
<li>User can update amount of each room in cart.</li>
<li>Click the Confirm button to store the booking to database (must store the buy date time). The warning
message will show if the selected room is out of stock.</li>
<li>During booking user enter the discount code (if any). Each discount code has its expiry date.</li>
</ul>
</li>
  
![booking_page](https://github.com/traitrantruon/hotel-booking/blob/main/image/booking-page.png)
  
<li>Function 5: Booking history – 100 LOC
<ul>
<li>User can take over the booking history: list of booking order by booking date.</li>
<li>Support search function: search by name or booking date.</li>
<li>Support delete function to delete the booking (update the status of booking to inactive).</li>
</ul>
</li>
  
![history-page](https://github.com/traitrantruon/hotel-booking/blob/main/image/history-page.png)
  
<li>Function 6: Booking confirm by email – 100 LOC (extra)</li>
<li>Function 7: Feedback on the quality of room service – 50 LOC (Extra)
<ul>
<li>Rating is performed only when the user has used the service.</li>
<li>Rating on a scale of: from 0 to 10.</li>
</ul>
</li>

## My database
![diagram](https://github.com/traitrantruon/hotel-booking/blob/main/image/diagram-database.png)
