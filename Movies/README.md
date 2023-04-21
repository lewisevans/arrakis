### Architecture

There are three main modules tha contain all the Application code
* :Presentation - Compose UI and ViewModels
* :Domain - UseCases and repository interfaces
* :Data - Concrete repositories, DataSources, Services and other things such as Room (not currently implemented)

And one module to tie them together
* :App

The dependencies go in towards to domain following the Clean Architecture principle therefore the Domain has no dependencies, the Presentation and Data only depend on the Domain and not each other.

These layers are all orchestrated from the application module.

### Caching
There is Caching in the Data layer achieved via a MemCache but currently it is not expiring. It would be a minor change to rectify this by adding a timestamp to the data.

### Testing
All testing is in the :App module currently but should really be inside each module

Fakes are currently duplicated in 'androidTestFakes' and 'testFakes' as we can't share code by adding one folder to both sourceSets any more. We need to create a module for shared code.
