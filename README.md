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
 a zero? done 
 a nonzero? a print a 1 - reduce done 
}

fact n {
  n zero? 1 done
  n nonzero? n n 1 - fact * done
}

fib n {
  n zero? 1 done
  n 1 - zero? 1 done
  n n 1 - * nonzero? n 1 - fib n 2 - fib + done
}

main {
 read 
 fact
 print
} 
</code></pre>