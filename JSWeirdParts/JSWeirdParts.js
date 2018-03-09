/**** BIG WORDS ****/

    /* Syntax Parser */
    // A program that reads your code and determines what it does and if its grammar is valid

    /* Lexical Environment */
    // Where something sits physically in the code you write
    // 'Lexical' means 'having to do with words or grammar'. A lexical environment exists in programming languages in which WHERE you write something is important!
    // The compiler cares about where you put things!

    /* Execution Context */
    // A wrapper to help manage the code that is running
    // There are lots of lexical environments. Which one is currently running is managed via execution contexts. It can contain things beyond what you've written in your code.

    /* Single Threaded */
    // One command is being executed at a time
    // Under the hood of the browswer, maybe not! Javascript isn't the only thing happening in the browser

    /* Synchronous */
    // One at a time, and in order!

    /* Invocation */
    // Running or calling a function
    // in JS, by using parenthesis ()

    /* Variable Environment */
    // Where the variables live, and how they relate to each other in memory

    /* Scope */
    // Where a variable is available in your code, and if it's truly the same variable, or a new copy

    /* Asynchronous */
    // More than one at a time
    // Different bits of code executing in parallel

    /* Dynamic Typing */
    // You don't tell the engine what type of data a variable holds, it figures it out while your code is running
    // Variables can hold different types of values because it's all figured out during execution
    // 'Static typing' is the opposite of this where you specify the variable type before execution (eg: bool isNew = 'hello' would throw an error)

    /* Primitive Type */
    // A type of data that represents a single values
    // That is, not an object

    /* Operators */
    // A special function that is syntactically (written) differently
    // Generally, operators take two parameters and return one result

    /* Operator Precendence */
    // Which operator function gets called first
    // Function are called in order of PRECEDENCE (Higher precedence wins)

    /* Associativity */
    // What order operator functions get called in: Left-to-Right or Right-to-Left
    // When functions have the 'same' precedence

    /* Coercion */
    // Converting a value from one type to another
    // This happens quite often in Javascript because it's dynamically typed


/**** CONCEPTUAL ASIDES ****/

    /* Name-Value Pairs and Objects */
    // A name which maps to a unique value
    // The name may be defined more than once, but only can have one value in any given context.
    // Simple example
    var address = '100 Main St.';
    // That value may be more name-value pairs eg: Objects
    // Object - A collection of name-value pairs. This is simplest definition when talking about Javascript
    address = {
      Street: 'Main',
      No: 100,
      Apartment: {
        Floor: 3,
        No: 301
      }
    };


    /* Javascript and 'Undefined' */
    console.log(a) // throw error 'a' is not defined
    // But...
    var a;
    console.log(a) // Undefined
    // This seems like it should be the same thing
    // However 'undefined' is a special value that JS has internally that means that the variable hasn't been set BUT it does have a place in memory, 'undefined' is a placeholder
    // To make debugging easier, never do this:
    a = undefined; // If you avoid this, you know that a undefined value means you never set the variable


    /* Single Threaded, Synchronous Execution */
    // In JS, only one thing is happening at a time
    // Each line of code is executed individually and in order


    /* Types and Javascript */
    // Because JS is dynamically typed, it allows you to keep changing the type of a variable without errors (JS will keep working out the variable type during execution):
    var isNew = true;
    isNew = 'true';
    isNew = 1;

    /* Operators */
    // + - * / % > < are actually functions!
    // However, to avoid calling them like +(2,3), JS allows whats known as 'infix notation', this allows the function name to sit between the two parameters (eg: 3 + 4)

    /* Coercion */
    var a = 1 + '2' // '12'
    // the first number value 1 has been automatically coerced into being a string, without us explicitly asking it to
    // Because JS is dynamically typed, it will try and convert the type without you having to ask


/**** FRAMEWORK ASIDE ****/

    /* Default Values */
    // in your index.html, if you had a couple of JS files:
    <script src="lib1.js"></script>
    <script src="lib2.js"></script>
    <script src="test.js"></script>
    // These aren't seperate execution contexts! They will be combined together into one global execution context
    // If you have a variable with the same name in both eg:
    var libraryName = 'lib1';
    var libraryName = 'lib2';
    // libraryName will get overwritten by the second one 'lib2'

    // You can use default values to check if it already exists
    var libraryName = 'lib1';
    window.libraryName = window.libraryName || 'lib2';



                                                            /***************|||||||||||||| EXECUTION CONTEXTS AND LEXICAL ENVIRONMENTS |||||||||||**********************/



/**** THE GLOBAL ENVIRONMENT AND THE GLOBAL OBJECT ****/

    // Your base execution context is your GLOBAL (ie: accessable to everything in your code) execution context
    // Your global exectution context creates a Global Object and a special variable called 'this'
    // In a browser, the global object is the Window Object (in a Node JS server the global object would be different)
    // If an empty Javascript file is run in the browser, 'this' will be a reference to the Window Object
    this === window // true
    // Each new tab has a seperate global object because each tab is its own global  execution context

    // 'Global' basically means 'Not inside a function'
    // Global variables and functions get attached to the global object, eg:
    var a = 'Hello'

    function b() {

    }
    // These are now both available on the global object
    window.a // 'Hello'
    window.b // function b() {}

    // Outer Environment refers to the level outside a function,
    // For the Global environment, there is no Outer Environment so this is equal to 'null'



/**** THE EXECUTION CONTEXT: CREATION AND 'HOISTING' ****/

    // Here is a weird Javascript thing:
    b(); // 'called b'
    console.log(a); // undefined

    var a = 'Hello';
    function b() {
      console.log('called b');
    }

    // In other languages, this would throw an error as the code is compiled line by line
    // Here we successfully called b() before it was defined, and a was undefined (rather than throwing an error)
    // if we had on its own:
    console.log(a); // This would throw an error saying 'a is not defined'

    // This phenomenon is called 'Hoisting'
    // The reason in JS that variables and functions are available (to some degree) before they are written in the code is because the execution context is created in two phases
    // The 1st phase is called 'The Creation Phase' - the Global Object (only for Global execution context) / 'this' / Outer Environment are created
    // It also setups Memory Space for Variables and Functions ("Hoisting"), the parser will recognise where you have created variables and functions
    // Code isn't being moved to the top of page, Hoisting means that - before your code begins to be executed line by line, the JS engine has already set aside memory space for all the variables & functions you've created
    // Because the variables/functions are already in memory, so when the code begins to execute line by line - it can access them
    // However, it's slightly different for variables. For functions, both the name and the code inside a function are stored in memory
    // Variables aren't assigned until the 2nd Phases 'The execution phase', in first stage where memory is created for variables - a placeholder of 'undefined' is used
    // All variables in Javascript are initially set to undefined whereas funcitons sit in memory in their entirity
    // This is why it's a bad idea to rely on Hoisiting


/**** THE EXECUTION CONTEXT: CODE EXECUTION ****/

    // This is stage 2 of execution context, where your code is actually executed
    // The code is run line by line - compiling it into something the computer can understand
    console.log(a); // undefined
    var a = 'Hello';
    console.log(a); // 'Hello'


/**** FUNCTION INVOCATION AND THE EXECUTION STACK ****/

    // Look at this example
    function b() {
    }

    function a() {
      b();
    }

    a();

    // If we step through this example being run, the first thing to be created is a Global Execution Context (including Global Object / 'this')
    // This is placed on the exectution stack
    // Then in the creation phase of the Execution Context, it will attach these functions to the global object and set up the memory space for them
    // When it hits a(), a new exectution context is created for a() and placed at the top of the exectution stack
    // This new exectution context will have its own space for new variables and functions
    // When it hits b(), another exectution context is created and put on top of the stack
    // In our example:
    /* 1. b() Execution Context(create and execute)
       2. a() Execution Context(create and execute)
       3. Global Execution Context(create and execute) */
    // Once finished exectuting, the execution context in popped off the stack, and the next one begins
    // A more complex example, where the execution order is labelled:
    function a() {
      b(); // 1st
      var c; // 2nd
    }

    function b() {
      var d; // 1st
    }

    a(); // 2nd
    var e; // 3rd

    // So to recap - everytime a function is called, a new execution context is created for that function (with a new 'this' variable), the variables within it are setup during the creation phase and the code within is executed line by line
    // Everytime a function is invoked (even if it's invoking itself!), a new execution context is created - put on top on the stack - then when the function finishes, it's popped off and whatever's next in line will start running line by line (synchronously)


/**** FUNCTIONS, CONTEXT, AND VARIABLE ENVIRONMENTS ****/

    function b() {
      var myVar;
      console.log(myVar); // undefined
    }

    function a() {
      var myVar = 2;
      console.log(myVar); // 2
      b();
    }

    var myVar = 1;
    console.log(myVar); // 1
    a();
    console.log(myVar); // 1 (not affected even after a() is invoked)

    // myVar is different each time as it exists seperately in each different execution context
    // Each exectution context has it's own variable environment, so even though myVar has the same name, each are distinct variables
    // Scope - where can each variable be viewed and accessed



/**** THE SCOPE CHAIN ****/

    function b() {
      console.log(myVar); // 1
    }

    function a() {
      var myVar = 2;
      b();
    }

    var myVar = 1;
    a();

    // Here we haven't defined myVar in b(), so it looks to its outer environment (in this case, the Global Execution context) for a variable named myVar
    // JS cares about the lexical environment when it comes to the outer reference that every execution context gets
    // If you ask for a variable when running a line of code in any particular execution context, if it can't find the variable it will go to outer reference and look for variables there (somewhere below it in the execution stack)
    // Where that outer reference points depends on where the the functions sits lexically
    // This chain of searching through outer environments is called the Scope Chain
    // What if we change the lexical environment of funtion b:
    function a() {
      var myVar = 2;
      function b() {
        console.log(myVar); // 2
        console.log(myVar2); // 5
      }
      b();
    }

    var myVar = 1;
    var myVar2 = 5;
    a();
    b(); // This would throw an error because function b isn't in the global environment, it's inside function a

    // Now the outer lexical environment of function b is function a, so it will search there first for the myVar variable, hence it will console.log 2 now
    // If function b can't find the variable in it's outer environment, it will move down the scope chain to it's next outer environment until it finds it or reaches Global Environemnt (where there is no outer environment)



/**** SCOPE, ES6 and Let ****/

    // ES6 introduces 'let' type, which allows JS engine to use Block Scoping
    // 'let' won't allow you to use the variable until after it has been assigned a value
    // it is still allocated memory and set to undefined in creaton phase, but unlike 'var' you can't use it till after it's assigned
    console.log(c);
    let c = 1; // This would throw an error 'c is not defined'

    // The other important aspect is whether it is declared inside a Block (generally defined by whether it is inside {})
    if(a > b)
      // When a let is declared inside a block, it's only available inside that block at that period of time for the running code
      let c = true;
    }
    console.log(c); // throws an error 'c is not defined'

    // This can have weird affect on for loops
    // If you are running the same code with a let statement, you'll get a different variable in memory each time the loop is running


/**** WHAT ABOUT ASYNCHRONOUS CALLBACKS? ****/

    // Javascript is Synchronous (ie: executes one line at a time)
    // How does it handle Asynchronous events like AJAX requests for data or click events that use callback functions once an action is complete?
    // Javascript uses something called 'the Event Queue'
    // New events (like a click events or HTTP response) get added to the event queue
    // We can listen out for these events and have a function handle that event
    // Once the execution stack is empty, JS looks at the event queue, JS periodically looks at the event queue and waits for an event
    // If it finds an event, it checks to see if a particular function should be run when that event is triggered
    // If there is a callback function, it creates a new execution context for that function and adds it to the execution stack
    // If there are more events in the queue, they will have to wait for the execution stack to be cleared before being handled
    // Remember JS is NOT Asynchronous, the other parts of the Browser is asynchronously putting events into the event queue but JS can only run line by line
    // Example:

    // Long running function
    function waitThreeSeconds() {
      var ms = 3000 + new Date().getTime();
      while (new Date() < ms) {} // wait three seconds
      console.log('finished function');
    }

    function clickHandler() {
      console.log('click event!');
    }

    // listen for the click event
    document.addEventListener('click', clickHandler);

    waitThreeSeconds();
    console.log('finished execution');

    // Here, if you click on the screen while Long running function is still going, the clickHandler function will not be executed until waitThreeSeconds function and the global code is complete
    // Order of console.logs:
    // 1. 'finished function'
    // 2. 'finished execution'
    // 3. 'click event!'

    // JS engine won't look at event queue until the stack is empty
    // This means long running functions can interupt event being handled
    // When execution stack is empty, JS will continue to watch the event loop and process events in the order that they happen






                                                                      /***************|||||||||||||| TYPES AND OPERATORS |||||||||||**********************/



/**** PRIMITIVE TYPES ****/

    // 6 primitive types in JS
    // 1. Undefined - 'undefined' represents a lack of existence (you shouldn't set a variable to this)
    // 2. Null - 'null' also represents lack of existence (but you can set a variable to this, if you want to say a variable has no value)
    // 3. Boolean - true or false
    // 4. Number - floating point number (there's always some decimals), unlike other programming languages, there's only one 'number' type...and it can make math weird
    // 5. String - a sequence of characters (both '' and "" can be used)
    // 6. Symbol - used in ES6 (next version of JS), we won't talk about it here

/**** OPERATOR PRECEDENCE AND ASSOCIATIVITY ****/

    var a = 3 + 4 * 5 //23
    // Remember that + and * are function calls
    // Which one is called first is dependant on their precedence
    // You can look up operator precedence here: (https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Operators/Operator_Precedence)
    // However, if you had:
    var a = (3 + 4) * 5; // 35
    // The parenthesis have the highest precedence so anything inside them is carried out first


    var a = 2, b = 3, c = 4;
    a = b = c;
    console.log(a, b, c) // 4, 4, 4
    // Because the only operator is =, there is equal precedence so we have to look at the ASSOCIATIVITY
    // For =, the associativity is Right-to-Left, so all variables are equal to 4
    // The return value of '=' function is the value you're assigning, so for:
    a = b = c;
    // return value of b = c is 4, so
    a = 4;

/**** COMPARISON OPERATORS ****/

    console.log(1 < 2 < 3); // true
    console.log(3 < 2 < 1); // true (seems weird right?)

    // the greater than (<) operator has Left-to-Right associativity, therefore:
    console.log(3 < 2 < 1)
    // The left side is calculated first, so we get:
    console.log(false < 1);
    // JS will try to coerce 'false' into a number, so it becomes 0 (number type)
    console.log(0 < 1); // true

    Number(true) // 1
    Number(false) // 0

    Number(undefined) // NaN (not a number)
    // NaN is quite a primitive type, it just means that a value couldn't be converted to a number

    Number(null) // 0

    // Equals operators:
    3 == 3 // true
    '3' == 3 // true (number 3 is coerced into being a string)
    false == 0 // true (false is coerced into number 0)
    null == 0 // false (special cases 'null' and 'undefined' which don't do what you'd expect), null doesn't coerce to 0 here
    '' == 0 // true
    '' == false // true

    // Strict Equals operators (===):
    // It will compare two values, but DOESN'T try to coerce them!
    // If two values aren't the same type, it will say false immediately
    3 === 3 // true
    '3' === '3' // true
    '3' === 3 // false

    0 === false // false
    //whereas
    0 == false // true

    // Use Strict Equals 99% of the time
    // Don't use == unless you conciously want to coerce the two values

    // Works the same way for Not Equal: != and !==


/**** EXISTENCE AND BOOLEANS ****/

    // Things that imply a lack of exisistence coerce to false
    Boolean(undefined) // false
    Boolean(null) // false
    Boolean("") // false
    Boolean(0) // false

    // Anything instead an if() statement will tried to be converted to a Boolean
    // These will all covert to false and never enter if statement
    if(undefined)
    if(null)
    if('')
    if(0)

    // These will convert to true, and will enter if statement
    if(1)
    if(-1)
    if('hello')

    // Because 0 doesn't techically mean lack of exisitence, you could use this:
    var a = 0;
    if(a || a === 0) // this would enter if statement, because a === 0 is true


/**** DEFAULT VALUES ****/

    function greet(name) {
      console.log('hello' + name);
    }

    greet('jamie') // log 'hello jamie'
    greet() // log 'hello undefined' (undefined is coerced into a string)

    // Even though we didn't pass a value in, JS will still have created memory space for 'name' value (during the creation phase - hoisting) and initially set the value to undefined
    // So name will be undefined if we don't pass anything in

    // If no name is passed in, we could set a default value like this:
    name = name || '<Your name here>';
    // Which ever value (going left to right) can be coerced to true will be returned

    greet('jamie') // 'hello jamie'
    greet() // 'hello <Your name here>'
    greet(0) // 'hello <Your name here>'




                                                          /***************|||||||||||||| OBJECTS AND FUNCTIONS |||||||||||**********************/

/**** OBJECTS AND THE DOT ****/

    // Remember we said objects are collections of name-value pairs, where they can have nested name-value pairs
    // How does an object reside in your computer's memory?
    // Objects can have properties and methods: Primitive "property" / Object "property" / Function "method"
    // The core object will have an address in memory (eg: 0x001);
