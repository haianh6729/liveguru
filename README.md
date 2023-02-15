
============================


### A typical top-level directory layout

    .                   
    ├── src                                              # source code files
    │    ├── main 
    │    │    └── java 
    │    │        ├── common                                                      
    │    │        ├── pageObjects                   
    │    │        ├── pageUIs 
    │    │        ├── resource 
    │    │        ├── utilities  
    │    │        └── log config files
    │    │
    │    └── test 
    │         └── java 
    │              └── testcase       
    │                             
    ├── pom.xml                                           # maven config file 
    └── testng.xml                                        # run testng file



# Source code files

    main : All Source code in project . Contain as Page Object Model.
    test : All automated test classes.

# common
    BaseTest and BasePage class, contain common methods. To support pageObjects (extends BasePage) and test class (extends BaseTest).

# pageObjects
    Contains pages of website as objects. Include method to manipulate on that page.

# pageUIs
    Define elements on the pages.

# resource 
    Test data and cookies
# Maven config file

    Contain dependencies for maven project
# Maven config file

    Set parameter and trigger automated test classes





### License information

If you want to share your work with others, please consider choosing an open
source license and include the text of the license into your project.
The text of a license is usually stored in the `LICENSE` (or `LICENSE.txt`,
`LICENSE.md`) file in the root of the project.

> You’re under no obligation to choose a license and it’s your right not to
> include one with your code or project. But please note that opting out of
> open source licenses doesn’t mean you’re opting out of copyright law.
> 
> You’ll have to check with your own legal counsel regarding your particular
> project, but generally speaking, the absence of a license means that default
> copyright laws apply. This means that you retain all rights to your source
> code and that nobody else may reproduce, distribute, or create derivative
> works from your work. This might not be what you intend.
>
> Even in the absence of a license file, you may grant some rights in cases
> where you publish your source code to a site that requires accepting terms
> of service. For example, if you publish your source code in a public
> repository on GitHub, you have accepted the [Terms of Service](https://help.github.com/articles/github-terms-of-service)
> which do allow other GitHub users some rights. Specifically, you allow others
> to view and fork your repository.

For more info on how to choose a license for an open source project, please
refer to http://choosealicense.com
