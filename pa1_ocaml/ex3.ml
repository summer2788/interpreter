
let rec gcd x y =
  if y = 0 then x else gcd y (x mod y)

(* Euler's Totient function *)
let phi a = 
  let rec count acc b =
    if b < a then
      let next_acc = if gcd a b = 1 then acc + 1 else acc in
      count next_acc (b + 1)
    else
      acc
  in
  count 0 1  (* Start counting from 1 as per the given range *)


  let () =
  Printf.printf "phi 4 => %d\n" (phi 4);
  Printf.printf "phi 9 => %d\n" (phi 9);
  Printf.printf "phi 10 => %d\n" (phi 10);
  Printf.printf "phi 17 => %d\n" (phi 17);
  Printf.printf "phi 30 => %d\n" (phi 30)