// Is "else" required?
{
    // The else isn't required, there will be no difference at all.
}

// Rewrite the function using '?' or '||'
{
    {
        function checkAge(age) {
            return (age > 18) ? true : confirm('Did parents allow you?');
        }
    }
    {
        function checkAge(age) {
            return (age > 18) || confirm('Did parents allow you?');
        }
    }
}

// Function min(a, b)
{
    function min(a, b) {
        return a <= b ? a : b;
    }
}

// Function pow(x,n)
{
    function pow(x, n) {
        let result = x;
        
        for (let i = 1; i < n; i++) {
            result *= x;
        }

        return result;
    }

    let x = prompt("Enter a number?");
    let n = prompt("Enter an integer greater than 1?");

    alert(pow(x, n));
}