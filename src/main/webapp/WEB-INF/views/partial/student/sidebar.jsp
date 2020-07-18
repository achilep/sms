<nav class="sidebar sidebar-offcanvas" id="sidebar">
    <ul class="nav">
        <li class="nav-item">
            <a class="nav-link" href="${pageContext.request.contextPath}/studentpanel">
                <i class="mdi mdi-home menu-icon"></i>
                <span class="menu-title">Dashboard</span>
            </a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="${pageContext.request.contextPath}/sprofilelink?getsid=${sessionScope.stinfo.stid}">
                <i class="mdi mdi-home menu-icon"></i>
                <span class="menu-title">Profile of ${sessionScope.UserLoggedIn}</span>
            </a>
        </li>
        <li class="nav-item">
            <a class="nav-link" data-toggle="collapse" href="#ui-basic" aria-expanded="false" aria-controls="ui-basic">
                <i class="mdi mdi-city menu-icon"></i>
                <span class="menu-title">Academic</span>
                <i class="menu-arrow"></i>
            </a>
            <div class="collapse" id="ui-basic">
                <ul class="nav flex-column sub-menu">
                    <li class="nav-item"> <a class="nav-link" href="showingacademicyearpage1">Academic Year</a></li>
                    <li class="nav-item"> <a class="nav-link" href="showingclassnamepage1">Classes</a></li>
                    <li class="nav-item"> <a class="nav-link" href="showclassroutinpage1">Class Routin</a></li>
                    <li class="nav-item"> <a class="nav-link" href="showclassteacherpage1">Class Teacher</a></li>
                    <li class="nav-item"> <a class="nav-link" href="showsectionpage">Section</a></li>
                    <li class="nav-item"> <a class="nav-link" href="showingexaminfopage1">Exam Information</a></li>
                    <li class="nav-item"> <a class="nav-link" href="showexammarkpage1">Exam Marks</a></li>
                    <li class="nav-item"> <a class="nav-link" href="showpaymentpage1">Fee Payment</a></li>
                    <li class="nav-item"> <a class="nav-link" href="showingnoticepage1">Notice</a></li>
                    <li class="nav-item"> <a class="nav-link" href="showingstgrouppage1">Student Group</a></li>
                    <li class="nav-item"> <a class="nav-link" href="studentinfoepage1">Student Information</a></li>
                    <li class="nav-item"> <a class="nav-link" href="showregistrationpage1">Student Registration</a></li>
                    <li class="nav-item"> <a class="nav-link" href="attendencpage1">Student Attendence</a></li>
                    <li class="nav-item"> <a class="nav-link" href="showguardianpage1">Student Guardian</a></li>
                    <li class="nav-item"> <a class="nav-link" href="showingsubjectpage1">Subjects</a></li>
                    <li class="nav-item"> <a class="nav-link" href="showteacherpage2">Teacher</a></li>
                </ul>
            </div>
        </li>
    </ul>
</nav>