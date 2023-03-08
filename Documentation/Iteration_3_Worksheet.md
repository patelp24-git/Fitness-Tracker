Iteration 3 Worksheet
=====================

What technical debt has been cleaned up
========================================

Show links to a commit where you paid off technical debt. Write 2-5 sentences
that explain what debt was paid, and what its classification is.

Technical debt that was resolved:
Implementation of the HSQLDB [https://code.cs.umanitoba.ca/3350-winter-2021-a02/group-4/group4project/-/commit/caa9bcedd558abdac4e11ed7821fc94735f9607a] 
Implementation of intergration tests
Implementation of features left over from iteration 2 [https://code.cs.umanitoba.ca/3350-winter-2021-a02/group-4/group4project/-/commit/79a137141a62ee9497377cc2aa6c0c7264a76e7b]
Resource extraction as well as fixing the variable types in the XML coding

What technical debt did you leave?
==================================

As a technical debt we had lot of stuff that we left to finish in the future version of the app. we didn't perform integration tests, we didn't implement many of our user story features that we planned initially. we didn't work on merging step counter to database in real time and planned to do it in the next version of the app.

Discuss a Feature or User Story that was cut/re-prioritized
============================================

Feature : BMI calculator [https://code.cs.umanitoba.ca/3350-winter-2021-a02/group-4/group4project/-/blob/master/app/src/main/java/comp3350/fitnesscompanion/presentation/Bmicalculator.java]
The change occured at the end of iteration 2. It was reprioritized due to the sudden shortage of group members. In an effort to reduce the work to the people avaliable we decided not to implement the storing ability of the BMI calculator as well as simplfy the response to the calculator

Acceptance test/end-to-end
==========================

All of our unit tests were successfull passed which tested majority of our logic layer. but when we run acceptance test and mockito at the same time build error can and we decided to comment mockito dependency when running the acceptance test and umcomment mockito dependency when running the unit tests. Thus, all of our test passed.

Acceptance test, untestable
===============

There were no challenges when we did acceptance tests. Most of our test were successful but Step Counter was difficult to test. 

Velocity/teamwork
=================

The velocity graph of our team depicts significant information about our group, it indicates that we are learning and we are trying to recover from our past mistakes. It shows that we are implementing more than we planned but in the best way possible. In the first two iterations, we lost some of our members as they were hit by a bus and our team was a bit unstable. Moreover, our commitment was more than our actual work, and also we had fewer participants to complete the planned tasks, this was a significant reason why we were not able to meet our goals. But, in the third iteration, we implemented more features than we initially expected, and in a way, we tried our best to balance the graph.