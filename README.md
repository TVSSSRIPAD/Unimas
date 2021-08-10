### Unimas - University Management System 

#### Problem Statement:- 
 - Every university has students attributes such as name, roll number, batch, email, phone number, gender, date of birth. Students enroll in courses. Each course has course_id, type, name, and the semester number in which the course will be offered. 
 - A course can also have prerequisite(s). Students attend their enrolled courses' and secure grades in them.
 - Besides this, each department has some faculty members working in it and each department offers some courses.
 - Each faculty member has the following attributes:- name, faculty_id, email, phone, password, salary, gender etc. A faculty member can also be the Head of Department (HOD). A faculty member teaches some particular courses in a semester.
 
 
#### ER Diagram:-

![Unimas_ER](https://user-images.githubusercontent.com/49719676/128855536-5ca48bbe-361d-4913-97d3-d974f46dfd37.png)

#### Functionalities:-
 - Each student can sign in to the website using his roll number or email and Date of birth. After logging in, the student can view his registered courses, grades and his attendance in the courses for which he has registered. 
 - Also, each student can select the courses they wish to join and can register for them among the courses which are being offered to him for the upcoming semester.
 - While registering, Prerequisite course checking is done to ensure that students have acquired the minimum grades in the prerequisite courses. 
 - Also, there are certain checks on attendance of students. Whenever attendance of a student for a particular course falls below a specified threshold, a notification message will be shown to the student.
 - The faculty members can also login to the website using their email and password. 
 - The faculty can view the list of all students registered for their courses (both past courses and currently ongoing courses). 
 - The faculty can also mark the attendance for students and can provide grades to the students for the ongoing courses. 
 - The faculty can choose the list of courses they wish to offer for the upcoming semester. 
 - Subject wise toppers are shown to faculty members for each of the courses taught by them. Students and faculty can also edit their profile details like phone number, address.
 - The HODs have the provision to add new courses, new faculty members and new students. The statistics like batch wise toppers, department wise toppers, program wise toppers (B.Tech / M.Tech) are also shown to HODs.


#### Tech Stack:-
##### Backend:
 - Spring Boot
 - JdbcTemplate
 - Oracle Database

##### FrontEnd:
 - Vanilla JavaScript and Bootstrap 


 Backend is built by [@TVSSSRIPAD](https://github.com/TVSSSRIPAD) & Frontend is built by [@kDushyanth](https://github.com/kDushyanth/)
 
