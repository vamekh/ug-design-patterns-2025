# Software Modeling and Design Patterns (INFO3027): Code Examples

Course material for **INFO3027 Software Modeling and Design Patterns** at the University of Georgia.

Every example comes in two versions:

- **Problem**: code on `main` that works but suffers from a design flaw (tight coupling, duplication, `if`/`instanceof` chains, class explosion…). Each problem commit is tagged `problem/<pattern>-<example>`.
- **Solution**: the same code refactored with one principle or pattern, on branch `solution/<pattern>-<example>`, which starts from the problem commit.

## How to compare "without" and "with" the pattern

On GitHub, click a **Compare** link in the table below. Locally:

```bash
git fetch --all --tags
git diff problem/strategy-shopping-cart...solution/strategy-shopping-cart   # note: three dots
git switch solution/strategy-shopping-cart                                  # browse the solution
```


## Build and run

Requires **Java 17** and Maven.

```bash
mvn test
```

Some problem versions contain tests that **fail on purpose** to demonstrate the flaw (e.g. the LSP `Square`/`Rectangle` test). They are tagged `@Tag("problem-demo")` and skipped by default. Run them with:

```bash
mvn test -Dsurefire.excludedGroups= -Dgroups=problem-demo
```

## Index

Each **notes** page explains the flaw, the pattern's roles and has before/after class diagrams.

| Week | Topic | Example | Notes | Compare |
|---|---|---|---|---|
| 1 | SOLID: Single Responsibility | Employee | [notes](https://github.com/vamekh/ug-design-patterns-2025/blob/solution/solid-srp-employee/docs/solid-srp-employee.md) | [compare](https://github.com/vamekh/ug-design-patterns-2025/compare/problem/solid-srp-employee...solution/solid-srp-employee) |
| 1 | SOLID: Open/Closed | Student distinction | [notes](https://github.com/vamekh/ug-design-patterns-2025/blob/solution/solid-ocp-student/docs/solid-ocp-student.md) | [compare](https://github.com/vamekh/ug-design-patterns-2025/compare/problem/solid-ocp-student...solution/solid-ocp-student) |
| 1 | SOLID: Liskov Substitution | Shapes | [notes](https://github.com/vamekh/ug-design-patterns-2025/blob/solution/solid-lsp-shapes/docs/solid-lsp-shapes.md) | [compare](https://github.com/vamekh/ug-design-patterns-2025/compare/problem/solid-lsp-shapes...solution/solid-lsp-shapes) |
| 1 | SOLID: Interface Segregation | Printer | [notes](https://github.com/vamekh/ug-design-patterns-2025/blob/solution/solid-isp-printer/docs/solid-isp-printer.md) | [compare](https://github.com/vamekh/ug-design-patterns-2025/compare/problem/solid-isp-printer...solution/solid-isp-printer) |
| 1 | SOLID: Dependency Inversion | Switch | [notes](https://github.com/vamekh/ug-design-patterns-2025/blob/solution/solid-dip-switch/docs/solid-dip-switch.md) | [compare](https://github.com/vamekh/ug-design-patterns-2025/compare/problem/solid-dip-switch...solution/solid-dip-switch) |
| 1 | SOLID: Dependency Inversion | Notifications | [notes](https://github.com/vamekh/ug-design-patterns-2025/blob/solution/solid-dip-notifications/docs/solid-dip-notifications.md) | [compare](https://github.com/vamekh/ug-design-patterns-2025/compare/problem/solid-dip-notifications...solution/solid-dip-notifications) |
| 1 | Simple Factory | Animals | [notes](https://github.com/vamekh/ug-design-patterns-2025/blob/solution/simple-factory-animals/docs/simple-factory-animals.md) | [compare](https://github.com/vamekh/ug-design-patterns-2025/compare/problem/simple-factory-animals...solution/simple-factory-animals) |
| 2 | Factory Method | Logistics | [notes](https://github.com/vamekh/ug-design-patterns-2025/blob/solution/factory-method-logistics/docs/factory-method-logistics.md) | [compare](https://github.com/vamekh/ug-design-patterns-2025/compare/problem/factory-method-logistics...solution/factory-method-logistics) |
| 2 | Factory Method | Video game | [notes](https://github.com/vamekh/ug-design-patterns-2025/blob/solution/factory-method-videogame/docs/factory-method-videogame.md) | [compare](https://github.com/vamekh/ug-design-patterns-2025/compare/problem/factory-method-videogame...solution/factory-method-videogame) |
| 2 | Abstract Factory | UI toolkit | [notes](https://github.com/vamekh/ug-design-patterns-2025/blob/solution/abstract-factory-uitoolkit/docs/abstract-factory-uitoolkit.md) | [compare](https://github.com/vamekh/ug-design-patterns-2025/compare/problem/abstract-factory-uitoolkit...solution/abstract-factory-uitoolkit) |
| 2 | Prototype | Cars | [notes](https://github.com/vamekh/ug-design-patterns-2025/blob/solution/prototype-cars/docs/prototype-cars.md) | [compare](https://github.com/vamekh/ug-design-patterns-2025/compare/problem/prototype-cars...solution/prototype-cars) |
| 3 | Builder | Computer | [notes](https://github.com/vamekh/ug-design-patterns-2025/blob/solution/builder-computer/docs/builder-computer.md) | [compare](https://github.com/vamekh/ug-design-patterns-2025/compare/problem/builder-computer...solution/builder-computer) |
| 3 | Builder | Car DTO / entity | [notes](https://github.com/vamekh/ug-design-patterns-2025/blob/solution/builder-car/docs/builder-car.md) | [compare](https://github.com/vamekh/ug-design-patterns-2025/compare/problem/builder-car...solution/builder-car) |
| 3 | Singleton | DB connection | [notes](https://github.com/vamekh/ug-design-patterns-2025/blob/solution/singleton-dbconnection/docs/singleton-dbconnection.md) | [compare](https://github.com/vamekh/ug-design-patterns-2025/compare/problem/singleton-dbconnection...solution/singleton-dbconnection) |
| 3 | Proxy (virtual) | Image processor | [notes](https://github.com/vamekh/ug-design-patterns-2025/blob/solution/proxy-imageprocessor/docs/proxy-imageprocessor.md) | [compare](https://github.com/vamekh/ug-design-patterns-2025/compare/problem/proxy-imageprocessor...solution/proxy-imageprocessor) |
| 3 | Proxy (logging, protection) | DB service | [notes](https://github.com/vamekh/ug-design-patterns-2025/blob/solution/proxy-dbservice/docs/proxy-dbservice.md) | [compare](https://github.com/vamekh/ug-design-patterns-2025/compare/problem/proxy-dbservice...solution/proxy-dbservice) |
| 4 | Decorator | Coffee | [notes](https://github.com/vamekh/ug-design-patterns-2025/blob/solution/decorator-coffee/docs/decorator-coffee.md) | [compare](https://github.com/vamekh/ug-design-patterns-2025/compare/problem/decorator-coffee...solution/decorator-coffee) |
| 4 | Decorator | Notifier | [notes](https://github.com/vamekh/ug-design-patterns-2025/blob/solution/decorator-notifier/docs/decorator-notifier.md) | [compare](https://github.com/vamekh/ug-design-patterns-2025/compare/problem/decorator-notifier...solution/decorator-notifier) |
| 4 | Decorator | UI component | [notes](https://github.com/vamekh/ug-design-patterns-2025/blob/solution/decorator-uicomponent/docs/decorator-uicomponent.md) | [compare](https://github.com/vamekh/ug-design-patterns-2025/compare/problem/decorator-uicomponent...solution/decorator-uicomponent) |
| 4 | Adapter | Pigeon & drone post | [notes](https://github.com/vamekh/ug-design-patterns-2025/blob/solution/adapter-pigeondrone/docs/adapter-pigeondrone.md) | [compare](https://github.com/vamekh/ug-design-patterns-2025/compare/problem/adapter-pigeondrone...solution/adapter-pigeondrone) |
| 4 | Adapter | Delivery app | [notes](https://github.com/vamekh/ug-design-patterns-2025/blob/solution/adapter-deliveryapp/docs/adapter-deliveryapp.md) | [compare](https://github.com/vamekh/ug-design-patterns-2025/compare/problem/adapter-deliveryapp...solution/adapter-deliveryapp) |
| 4 | Facade | Home theatre | [notes](https://github.com/vamekh/ug-design-patterns-2025/blob/solution/facade-hometheatre/docs/facade-hometheatre.md) | [compare](https://github.com/vamekh/ug-design-patterns-2025/compare/problem/facade-hometheatre...solution/facade-hometheatre) |
| 5 | Flyweight | Forest game | [notes](https://github.com/vamekh/ug-design-patterns-2025/blob/solution/flyweight-forestgame/docs/flyweight-forestgame.md) | [compare](https://github.com/vamekh/ug-design-patterns-2025/compare/problem/flyweight-forestgame...solution/flyweight-forestgame) |
| 5 | Composite | File system | [notes](https://github.com/vamekh/ug-design-patterns-2025/blob/solution/composite-filesystem/docs/composite-filesystem.md) | [compare](https://github.com/vamekh/ug-design-patterns-2025/compare/problem/composite-filesystem...solution/composite-filesystem) |
| 5 | Composite | Org chart | [notes](https://github.com/vamekh/ug-design-patterns-2025/blob/solution/composite-orgchart/docs/composite-orgchart.md) | [compare](https://github.com/vamekh/ug-design-patterns-2025/compare/problem/composite-orgchart...solution/composite-orgchart) |
| 5 | Bridge | Remote & device | [notes](https://github.com/vamekh/ug-design-patterns-2025/blob/solution/bridge-remote-device/docs/bridge-remote-device.md) | [compare](https://github.com/vamekh/ug-design-patterns-2025/compare/problem/bridge-remote-device...solution/bridge-remote-device) |
| 6 | Template Method | Hot beverage | [notes](https://github.com/vamekh/ug-design-patterns-2025/blob/solution/template-method-beverage/docs/template-method-beverage.md) | [compare](https://github.com/vamekh/ug-design-patterns-2025/compare/problem/template-method-beverage...solution/template-method-beverage) |
| 6 | Observer | Job seeker | [notes](https://github.com/vamekh/ug-design-patterns-2025/blob/solution/observer-jobseeker/docs/observer-jobseeker.md) | [compare](https://github.com/vamekh/ug-design-patterns-2025/compare/problem/observer-jobseeker...solution/observer-jobseeker) |
| 6 | Observer | Restaurant pickup | [notes](https://github.com/vamekh/ug-design-patterns-2025/blob/solution/observer-restaurant/docs/observer-restaurant.md) | [compare](https://github.com/vamekh/ug-design-patterns-2025/compare/problem/observer-restaurant...solution/observer-restaurant) |
| 6 | Observer | Evaluation notifier | [notes](https://github.com/vamekh/ug-design-patterns-2025/blob/solution/observer-evaluationnotifier/docs/observer-evaluationnotifier.md) | [compare](https://github.com/vamekh/ug-design-patterns-2025/compare/problem/observer-evaluationnotifier...solution/observer-evaluationnotifier) |
| 6 | Chain of Responsibility | Vacation request | [notes](https://github.com/vamekh/ug-design-patterns-2025/blob/solution/chain-of-responsibility-vacation/docs/chain-of-responsibility-vacation.md) | [compare](https://github.com/vamekh/ug-design-patterns-2025/compare/problem/chain-of-responsibility-vacation...solution/chain-of-responsibility-vacation) |
| 6 | Chain of Responsibility | Mail validation | [notes](https://github.com/vamekh/ug-design-patterns-2025/blob/solution/chain-of-responsibility-mail/docs/chain-of-responsibility-mail.md) | [compare](https://github.com/vamekh/ug-design-patterns-2025/compare/problem/chain-of-responsibility-mail...solution/chain-of-responsibility-mail) |
| 7 | Iterator | Graph DFS / BFS | [notes](https://github.com/vamekh/ug-design-patterns-2025/blob/solution/iterator-dfs/docs/iterator-dfs.md) | [compare](https://github.com/vamekh/ug-design-patterns-2025/compare/problem/iterator-dfs...solution/iterator-dfs) |
| 7 | Command | Home remote | [notes](https://github.com/vamekh/ug-design-patterns-2025/blob/solution/command-homeremote/docs/command-homeremote.md) | [compare](https://github.com/vamekh/ug-design-patterns-2025/compare/problem/command-homeremote...solution/command-homeremote) |
| 7 | Memento | Game save | [notes](https://github.com/vamekh/ug-design-patterns-2025/blob/solution/memento-game/docs/memento-game.md) | [compare](https://github.com/vamekh/ug-design-patterns-2025/compare/problem/memento-game...solution/memento-game) |
| 9 | Strategy | Shopping cart | [notes](https://github.com/vamekh/ug-design-patterns-2025/blob/solution/strategy-shopping-cart/docs/strategy-shopping-cart.md) | [compare](https://github.com/vamekh/ug-design-patterns-2025/compare/problem/strategy-shopping-cart...solution/strategy-shopping-cart) |
| 9 | State | Coffee machine | [notes](https://github.com/vamekh/ug-design-patterns-2025/blob/solution/state-coffeemachine/docs/state-coffeemachine.md) | [compare](https://github.com/vamekh/ug-design-patterns-2025/compare/problem/state-coffeemachine...solution/state-coffeemachine) |
| 9 | State | Tape player | [notes](https://github.com/vamekh/ug-design-patterns-2025/blob/solution/state-tapeplayer/docs/state-tapeplayer.md) | [compare](https://github.com/vamekh/ug-design-patterns-2025/compare/problem/state-tapeplayer...solution/state-tapeplayer) |
| 9 | Mediator | Chat | [notes](https://github.com/vamekh/ug-design-patterns-2025/blob/solution/mediator-chat/docs/mediator-chat.md) | [compare](https://github.com/vamekh/ug-design-patterns-2025/compare/problem/mediator-chat...solution/mediator-chat) |
| 10 | Visitor | E-commerce | [notes](https://github.com/vamekh/ug-design-patterns-2025/blob/solution/visitor-ecommerce/docs/visitor-ecommerce.md) | [compare](https://github.com/vamekh/ug-design-patterns-2025/compare/problem/visitor-ecommerce...solution/visitor-ecommerce) |
| 10 | Visitor | Museum tour guide | [notes](https://github.com/vamekh/ug-design-patterns-2025/blob/solution/visitor-tourguide/docs/visitor-tourguide.md) | [compare](https://github.com/vamekh/ug-design-patterns-2025/compare/problem/visitor-tourguide...solution/visitor-tourguide) |
| 10 | Visitor | Expression tree | [notes](https://github.com/vamekh/ug-design-patterns-2025/blob/solution/visitor-expression/docs/visitor-expression.md) | [compare](https://github.com/vamekh/ug-design-patterns-2025/compare/problem/visitor-expression...solution/visitor-expression) |
| 10 | Interpreter | Math expressions | [notes](https://github.com/vamekh/ug-design-patterns-2025/blob/solution/interpreter-math/docs/interpreter-math.md) | [compare](https://github.com/vamekh/ug-design-patterns-2025/compare/problem/interpreter-math...solution/interpreter-math) |
| 10 | Interpreter | Palindrome grammar | [notes](https://github.com/vamekh/ug-design-patterns-2025/blob/solution/interpreter-palindrome/docs/interpreter-palindrome.md) | [compare](https://github.com/vamekh/ug-design-patterns-2025/compare/problem/interpreter-palindrome...solution/interpreter-palindrome) |
| 10 | Null Object | Student evaluation | [notes](https://github.com/vamekh/ug-design-patterns-2025/blob/solution/null-object-studentevaluation/docs/null-object-studentevaluation.md) | [compare](https://github.com/vamekh/ug-design-patterns-2025/compare/problem/null-object-studentevaluation...solution/null-object-studentevaluation) |
| 10 | Null Object | Logger | [notes](https://github.com/vamekh/ug-design-patterns-2025/blob/solution/null-object-logger/docs/null-object-logger.md) | [compare](https://github.com/vamekh/ug-design-patterns-2025/compare/problem/null-object-logger...solution/null-object-logger) |
| 11 | MVC | Gradebook | [notes](https://github.com/vamekh/ug-design-patterns-2025/blob/solution/mvc-gradebook/docs/mvc-gradebook.md) | [compare](https://github.com/vamekh/ug-design-patterns-2025/compare/problem/mvc-gradebook...solution/mvc-gradebook) |
| 12 | Anti-pattern: God Object | Order manager | [notes](https://github.com/vamekh/ug-design-patterns-2025/blob/solution/antipattern-god-object/docs/antipattern-god-object.md) | [compare](https://github.com/vamekh/ug-design-patterns-2025/compare/problem/antipattern-god-object...solution/antipattern-god-object) |
| 12 | Anti-pattern: Singleton abuse | App config | [notes](https://github.com/vamekh/ug-design-patterns-2025/blob/solution/antipattern-singleton-abuse/docs/antipattern-singleton-abuse.md) | [compare](https://github.com/vamekh/ug-design-patterns-2025/compare/problem/antipattern-singleton-abuse...solution/antipattern-singleton-abuse) |
| 12 | Anti-pattern: Golden Hammer | Date formatting | [notes](https://github.com/vamekh/ug-design-patterns-2025/blob/solution/antipattern-golden-hammer/docs/antipattern-golden-hammer.md) | [compare](https://github.com/vamekh/ug-design-patterns-2025/compare/problem/antipattern-golden-hammer...solution/antipattern-golden-hammer) |

## Repository layout

```
src/main/java/ge/edu/ug/
├── solid/                      SOLID principles (srp, ocp, lsp, isp, dip)
├── patterns/creational/        simple factory, factory method, abstract factory, prototype, builder, singleton
├── patterns/structural/        proxy, decorator, adapter, facade, flyweight, composite, bridge
├── patterns/behavioral/        template method, observer, chain of responsibility, iterator, command,
│                               memento, strategy, state, mediator, visitor, interpreter, null object
├── architectural/mvc/          Model-View-Controller
└── antipatterns/               anti-patterns and their refactorings
```

Other branches: `classwork/*` keeps the code written live in lectures, for reference only. It is not part of the curriculum.
