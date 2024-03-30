let fibo n  =

  let rec aux n a b =
    if n = 0 then a
    else aux (n - 1) b (a + b)
  in
  aux n 0 1


  let () =
  Printf.printf "fibo 0 => %d\n" (fibo 0);
  Printf.printf "fibo 1 => %d\n" (fibo 1);
  Printf.printf "fibo 2 => %d\n" (fibo 2);
  Printf.printf "fibo 3 => %d\n" (fibo 3);
  Printf.printf "fibo 7 => %d\n" (fibo 7);
  Printf.printf "fibo 10 => %d\n" (fibo 10)
  