<nav class="sidebar sidebar-offcanvas" id="sidebar">
    <ul class="nav">
        <li class="nav-item">
            <a class="nav-link" href="${pageContext.request.contextPath}/teacherpanel">
                <i class="mdi mdi-home menu-icon"></i>
                <span class="menu-title">Dashboard</span>
            </a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="${pageContext.request.contextPath}/tprofilelink?gettid=${sessionScope.teinfo.tid}">
                <i class="mdi mdi-account-circle menu-icon"></i>
                <span class="menu-title">Profile of ${sessionScope.UserLoggedIn}</span>
            </a>
        </li>
        <li class="nav-item"> <a class="nav-link" href="showingclassnamefromteacherpage">Classes</a></li>
                    <li class="nav-item"> <a class="nav-link" href="showingexaminfoteacherpage">Exam Information</a></li>
                    <li class="nav-item"> <a class="nav-link" href="showexammarkpageytecaher">Exam Marks</a></li>
                    <li class="nav-item"> <a class="nav-link" href="showingnoticetoteacherpage">Notice</a></li>
                    <li class="nav-item"> <a class="nav-link" href="showingstgrouppagefromteacher">Student Group</a></li>
                    <li class="nav-item"> <a class="nav-link" href="studentinfoepagefromteacher">Student Information</a></li>
                    <li class="nav-item"> <a class="nav-link" href="attendencpageforteacher">Student Attendence</a></li>
                    <li class="nav-item"> <a class="nav-link" href="showguardianfromteacherpage">Student Guardian</a></li>
    </ul>
</nav>