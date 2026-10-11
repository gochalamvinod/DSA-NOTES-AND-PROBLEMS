// let -> blocked scoped
// var -> fuctional scoped


// backtick ` ` -> used for multi line string
let string = `Hi
my name
is
Aditya`;
console.log(string);

let age = 23;
let Name = "Aditya";
console.log(`My name is ${Name} and my age is ${age}`);

console.log("-------------")
// rest operator
function add(...numbers){
    let total =0;
    for(let num of numbers){
        total += num;
    }
    return total;
}
console.log(add(10,20));
console.log(add(10,20,30,40));
console.log("-------------")


// Spread operator --> we can copy to arrays
let a = [1,2,3];
let b = [2,3,6];
let c = [...a,...b];
console.log(c);

let frontend = ["HTML","React","Javascript","CSS"]
let backend = ["Java","Spring Boot"]
let fullStack = [...frontend,...backend];
console.log(fullStack);

let movie = {
    mvname:"DC",
    mvtckcost:"250"
};
let director = {
    ...movie,
    hero:"Lokesh Kanagraj",
    mvtckcost:"350"
}

console.log(director);
console.log("-------------")




// Destructuring

let person ={
    Naam:"Aditya",
    Age:"25",
    mail:"aditya@gmail.com"
}
console.log(person.Naam)
let{Naam,Age,mail} = person;
console.log(Naam,Age,mail)
console.log(" ")
let colors =["Red","Green","Blue"];
// with ES6 array destructuring
let[first,second,third] = colors;
console.log(first)
console.log(second)
console.log(third)
console.log("-------------")
// without ES6 array destructuring
console.log(colors[0]);
console.log(colors[1]);
console.log(colors[2]);

let employee = ["Raj","Java Developer",70000];
let[naam,role,salary] = employee;
console.log(naam,role,salary);