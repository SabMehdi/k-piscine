/* for (let i = 0; i < 5; i++) console.log(i);
for (let i = 0; i < 5; ++i) console.log(i);

//they are the same

for (let i = 2; i <= 10; i++) {
    if (i % 2 == 0) {
      alert( i );
    }
  }
 */
/* let i = 0;
while (i < 3) {
  console.log( i);
  i++;
} */

/* let num;

do {
  num = prompt("Enter a number greater than 100");
} while (num <= 100 && num); */


for(let i=2; i<=1000000; i++){
    prime = true;
  for(let j=2; j<i; j++){
    if(i%j==0){
        prime = false;
        break;
    }
  } 
  if(prime){
    console.log(i);
  }
    
}