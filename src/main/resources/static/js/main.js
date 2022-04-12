(function($) { "use strict";

    $(function() {
        var header = $(".start-style");
        $(window).scroll(function() {
            var scroll = $(window).scrollTop();

            if (scroll >= 10) {
                header.removeClass('start-style').addClass("scroll-on");
            } else {
                header.removeClass("scroll-on").addClass('start-style');
            }
        });
    });

    //Animation

    $(document).ready(function() {
        $('body.hero-anime').removeClass('hero-anime');
    });

    //Menu On Hover

    $('body').on('mouseenter mouseleave','.nav-item',function(e){
        if ($(window).width() > 750) {
            var _d=$(e.target).closest('.nav-item');_d.addClass('show');
            setTimeout(function(){
                _d[_d.is(':hover')?'addClass':'removeClass']('show');
            },1);
        }
    });

    //Switch light/dark

    $("#switch").on('click', function () {
        if ($("body").hasClass("dark")) {
            $("body").removeClass("dark");
            $("#switch").removeClass("switched");
        }
        else {
            $("body").addClass("dark");
            $("#switch").addClass("switched");
        }
    });

})(jQuery);

/* Dropdown */
$(document).ready(function(){
    $("select.dropdown").change(function(){
        var value = $(this).children("option:selected").val();
        /* message for testing purposes */
        /*alert("You have selected - " + value);*/
    });
});

/* bootcamp page */
    function showLecturers() {
    var lecturersTable = document.getElementById("lecturers");
    var studentsTable = document.getElementById("students");
    var tasksTable = document.getElementById("tasks");
    if (lecturersTable.style.display === "none") {
    lecturersTable.style.display = "block";
    studentsTable.style.display = "none";
    tasksTable.style.display = "none";
} else {
    lecturersTable.style.display = "none";
    studentsTable.style.display = "block";
    tasksTable.style.display = "block";
}
}

/* bootcamp page */
    function showStudents() {
    var lecturersTable = document.getElementById("lecturers");
    var studentsTable = document.getElementById("students");
    var tasksTable = document.getElementById("tasks");
    if (studentsTable.style.display === "none") {
    studentsTable.style.display = "block";
    lecturersTable.style.display = "none";
    tasksTable.style.display = "none";
} else {
    studentsTable.style.display = "none";
    lecturersTable.style.display = "block";
    tasksTable.style.display = "block";
}
}

/* bootcamp page */
    function showTasks() {
    var lecturersTable = document.getElementById("lecturers");
    var studentsTable = document.getElementById("students");
    var tasksTable = document.getElementById("tasks");
    if (tasksTable.style.display === "none") {
    tasksTable.style.display = "block";
    studentsTable.style.display = "none";
    lecturersTable.style.display = "none";
} else {
    tasksTable.style.display = "none";
    studentsTable.style.display = "block";
    lecturersTable.style.display = "block";
}
}
