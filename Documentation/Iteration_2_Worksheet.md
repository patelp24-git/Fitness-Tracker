Iteration 2 Worksheet
=====================

Paying off technical debt
-----------------

Tell the story of how one of your features was added to the project.
Provide links to the
feature, user stories, and merge requests (if used), associated tests, and merge commit
that was used to complete the feature.

Use one or two paragraphs which can have point-form within them.

No new features were added to the project.
Instead, we spent the time in an attempt to pay off the technical debt gathered from the last feature. 
This due to the loss of our group members. 
Because there are only 2 members now, we do not have the time or the resources to implement the other previously stated features. 
Following the previous iteration we followed the same formulae.
We made the mistake of using the android library sql instead of the HSQLDB as this came from a misunderstanding of the instructions.
Due to the sudden loss of members coupled with other circumstances the change to HSQLDB was not finished in time.
A branch separate from the main branch was created to develop this feature. 
Once it was in a state where it had some functionality and passed all tests a merge request was made.
Another group member then did a review of the branch and accepted the merge request once they decided it was up to standard.
Another branch was created to change the overall architecture and package design so that it fit with our planned architecture.
This branch was once again merged after review. Another branch was created in order to fix up the file structure for our database
as well as removing some extra files for the step counter. This branch was once again reviewed and merged into the master branch.
In the end, the feature was in a functional state but it did not satisfy all of the user stories associated with it. The app was 
also uploaded to an android phone so the feature could be tested in the real world.


Links:
1. [Feature](https://code.cs.umanitoba.ca/3350-winter-2021-a02/group-4/group4project/-/issues/3)
2. [User story 1](https://code.cs.umanitoba.ca/3350-winter-2021-a02/group-4/group4project/-/issues/8)
3. [User story 2](https://code.cs.umanitoba.ca/3350-winter-2021-a02/group-4/group4project/-/issues/9)

SOLID
----------------

[SOLID Violation in group 2s project](https://code.cs.umanitoba.ca/3350-winter-2021-a02/group-2/my-group-pal/-/issues/62)

Retrospective
----------
Describe how the retrospective has changed the way you are doing your project. Is there evidence of the change in estimating/committing/peer review/timelines/testing? Provide those links and evidence here - or explain why there is not evidence.

The change resulting from the previous retrospective is an improvement in code quality. That is we were able to more easily recognize and deal with code smells as evident by the fixing the failings that resulted from the  structure of the data object. A link to the User object will be provided however this resultant change is shown throughout the project.
Link to User object: (https://code.cs.umanitoba.ca/3350-winter-2021-a02/group-4/group4project/-/tree/master/app/src/main/java/comp3350/fitnesscompanion/objects)
The database layer had no integration with other layers, it also violated the 3 tier architecture we were trying to achieve. The changes made here were to allow for a logic and a persistence layer each taking in their own responsibilities as they should in accordance with the database. 
Link: (https://code.cs.umanitoba.ca/3350-winter-2021-a02/group-4/group4project/-/tree/master/app/src/main/java/comp3350/fitnesscompanion/Presistense)

Provide a link to where you describe your branching strategy.

[Group 4 Branching Strategy](https://code.cs.umanitoba.ca/3350-winter-2021-a02/group-4/group4project/-/blob/master/Documentation/Group4Branching.md)

Provide screen shot of a feature being added using your branching strategy
successfully. The [GitLab Graph tool can do this](https://code.cs.umanitoba.ca/comp3350-summer2019/cook-eBook/-/network/develop),
as well as using `git log --graph`.

[Screenshot of branching strategy](https://code.cs.umanitoba.ca/3350-winter-2021-a02/group-4/group4project/-/blob/master/Documentation/Screenshots/Branching.png)
being used successfully to implement our fake database 

Design Patterns
-----------

The design pattern used would be the builder design patten.
Link:(https://code.cs.umanitoba.ca/3350-winter-2021-a02/group-4/group4project/-/blob/master/app/src/main/java/comp3350/fitnesscompanion/Presistense/UserPersistenceSQLiteDB.java)



Iteration 1 Feedback fixes
--------------

We changed the FakeDatabase structure by adding UserPersistence Interface into Persistence layer that Interacts with both Fake Database and real Database and additionally it integrates to the logic layer as well. Initially our database had no interaction with our logic layer but we fixed it in this iteration by making it interactive. We didn’t have any content on the MainActivity page and fixed that by adding content. We didn’t have a back button to go back and forth and we implemented it this iteration. We worked on bugs in StepCounter and made it work for this iteration.

Links to fixes:
1. [fixed from iteration 1](https://code.cs.umanitoba.ca/3350-winter-2021-a02/group-4/group4project/-/issues/21)
2. [changed structure](https://code.cs.umanitoba.ca/3350-winter-2021-a02/group-4/group4project/-/blob/master/Documentation/Screenshots/ArchitectureDiagram.png)
