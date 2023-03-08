Iteration 1 Worksheet
=====================

Adding a feature
-----------------

Tell the story of how one of your features was added to the project.
Provide links to the
feature, user stories, and merge requests (if used), associated tests, and merge commit
that was used complete the feature.

Use one or two paragraphs which can have point-form within them.

This feature was worked on and developed individually by one of our group members.
A branch seperate from the main branch was created to develop this feature. 
Once it was in a state where it had some functionality and passed all tests a merge request was made.
Another group member then did a review of the branch and accepted the merge request once they decided it was up to standard.
Another branch was created to change the overall architecture and package design so that it fit with our planned architecture.
This branch was once again merged after review. Another branch was created in order to fix up the file structure for our database
as well as removing some extra files for the step counter. This branch was once again reviewed and merged into the master branch.
In the end, the feature was in a funtional state but it did not satisfy all of the user stories associated with it. The app was 
also uploaded to an android phone so the feature could be tested in the real world.

Links:
1. [Feature](https://code.cs.umanitoba.ca/3350-winter-2021-a02/group-4/group4project/-/issues/3)
2. [User story 1](https://code.cs.umanitoba.ca/3350-winter-2021-a02/group-4/group4project/-/issues/8)
3. [User story 2](https://code.cs.umanitoba.ca/3350-winter-2021-a02/group-4/group4project/-/issues/9)
4. [Merge request 1](https://code.cs.umanitoba.ca/3350-winter-2021-a02/group-4/group4project/-/merge_requests/1)
5. [Merge request 2](https://code.cs.umanitoba.ca/3350-winter-2021-a02/group-4/group4project/-/merge_requests/3)
6. [Merge request 3](https://code.cs.umanitoba.ca/3350-winter-2021-a02/group-4/group4project/-/merge_requests/5)

Exceptional code
----------------

Provide a link to a test of exceptional code. In a few sentences,
provide an explanation of why the exception is handled or thrown
in the code you are testing.

[link to test of exceptional code](https://code.cs.umanitoba.ca/3350-winter-2021-a02/group-4/group4project/-/blob/master/app/src/test/java/comp3350/fitnesscompanion/TestFakeDatabase.java)

The code being tested throws exceptions for the following reasons:
1. An attempt to create database table with a dublicate name was made. Duplicate database tables aren't allowed since we would't be able to distinguish between them
2. An attempt to read data from a database table that does not exist has been made
3. An attempt to read a non-existant row in an existing table was made
4. An attempt to add a row to a non-existant row was made
5. An attempt to delete a non-existant or already deleted table was made
6. An attempt to delete a non-existant or already deleted table row was made
7. An attempt to delete a row from a non-existant table was made

Branching
----------

Provide a link to where you describe your branching strategy.

[Group 4 Branching Strategy](./Documentation/Group4Branching.md)

Provide screen shot of a feature being added using your branching strategy
successfully. The [GitLab Graph tool can do this](https://code.cs.umanitoba.ca/comp3350-summer2019/cook-eBook/-/network/develop),
as well as using `git log --graph`.

[Screenshot of branching strategy](../Documentation/Screenshots/Branching.png)
being used successfully to implement our fake database 

SOLID
-----

Find a SOLID violation in the project of group `(n%12)+1` (group 12 does group 1).
Open an issue in their project with the violation,
clearly explaining the SOLID violation - specifying the type, provide a link to that issue. Be sure
your links in the issues are to **specific commits** (not to `main`, or `develop` as those will be changed).

Provide a link to the issue you created here.

[SOLID Violation in group 5s project](https://code.cs.umanitoba.ca/3350-winter-2021-a02/group5/-/issues/39)

Agile Planning
--------------

Write a paragraph about any plans that were changed. Did you
'push' any features to iteration 2? Did you change the description
of any Features or User Stories? Have links to any changed or pushed Features
or User Stories.

We ended up pushing both our user accounts and calorie tracker features to iteration 2 due to time constraints and other unexpected circumstances.
Medical emergency and hospitilization prevented one group member from being able to work on the project while another group members ability to 
contribute was hampered by illness. Implementing the "dummy" database and step counter features took a much longer time than expected as well, 
and team members overestimated the time they had available to work on some of these features. We also ended up pushing some of the user stories 
that required connecting the step counter with the database layer to the second iteration. We were left with a functional step counter without 
permanent storage, but our plans to implement the permanent storage aspect of the step counter have not changed.

Links to changes:
1. [Pushed user accounts feature to next iteration](https://code.cs.umanitoba.ca/3350-winter-2021-a02/group-4/group4project/-/issues/4)
2. [Pushed Calorie tracker feature to next iteration](https://code.cs.umanitoba.ca/3350-winter-2021-a02/group-4/group4project/-/issues/2)
3. [Pushed tracking steps over time user story to next iteration](https://code.cs.umanitoba.ca/3350-winter-2021-a02/group-4/group4project/-/issues/9)
