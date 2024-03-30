let rec gcd n m =
   if m = 0 then n          
   else gcd m (n mod m);;

   let () =
   Printf.printf "gcd 10 0 => %d\n" (gcd 10 0);
   Printf.printf "gcd 9 5 => %d\n" (gcd 9 5);
   Printf.printf "gcd 13 13 => %d\n" (gcd 13 13);
   Printf.printf "gcd 37 600 => %d\n" (gcd 37 600);
   Printf.printf "gcd 0 0 => %d\n" (gcd 0 0);;


   