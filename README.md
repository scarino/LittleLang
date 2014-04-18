LittleLang
==========

A toy language interpreter.

Example
-------

<pre><code>
add a b { 
 a b + 
}

sub a b { 
 a b - 
}

mul a b { 
 a b * 
}

square a {
 a a *
}

reduce a { 
 a eq? done 
 a neq? a print a 1 - reduce done 
}

count end start {
 end start - eq? start print done
 end start - neq? start print start 1 + end count done
}

count2 inc end start {
 end start - lt? done
 end start - eq? start print done 
 end start - gt? start print start inc + end inc count2 done
}

fact n {
  n eq? 1 done
  n neq? n n 1 - fact * done
}

fib n {
  n eq? 1 done
  n 1 - eq? 1 done
  n n 1 - * neq? n 1 - fib n 2 - fib + done
}

main {
 read
 read
 read
 count2

 read
 read
 add
 print

 read
 fact
 print

 read
 fib
 print
} 
</code></pre>