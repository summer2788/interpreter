
(* Check if a number is prime *)
let prime_check num =
  let rec divisor_check div =
    div * div > num || (num mod div <> 0 && divisor_check (div + 1))
  in
  num > 1 && divisor_check 2

(* Retrieve a prime pair whose sum is the specified even number *)
let find_goldbach even_num =
  let rec find_pair candidate =
    if prime_check candidate && prime_check (even_num - candidate) then (candidate, even_num - candidate)
    else find_pair (candidate + 1)
   in
  if even_num > 2 then find_pair 2 else (0, 0)

(* Generate a list with the Goldbach pairs within specified limits *)
let goldbach_range start finish min_prime =
  let min_start = max start 3 in
  let rec gather_pairs current acc =
    if current > finish then List.rev acc
     else if current >= min_start && current mod 2 = 0 then
      let primes = find_goldbach current in
      if fst primes >= min_prime && snd primes >= min_prime then
        gather_pairs (current + 2) ((current, primes) :: acc)
      else gather_pairs (current + 2) acc
    else gather_pairs (current + 1) acc
   in
    gather_pairs min_start []


(* Converts a goldbach list into a string representation *)
let string_of_goldbach_list lst =
  let rec aux acc = function
    | [] -> acc
    | [(n, (a, b))] -> acc ^ Printf.sprintf "(%d, (%d, %d))" n a b
    | (n, (a, b)) :: t -> aux (acc ^ Printf.sprintf "(%d, (%d, %d)); " n a b) t
    
  in
  "[" ^ aux "" lst ^ "]"
  
(* Test cases *)
let () =
let print_goldbach_list lst =
  Printf.printf "%s\n" (string_of_goldbach_list lst)
in
print_goldbach_list (goldbach_range 9 20 5);
print_goldbach_list (goldbach_range 25 70 10);
print_goldbach_list (goldbach_range 100 100 100);
print_goldbach_list (goldbach_range 100 200 19);
print_goldbach_list (goldbach_range 50 500 20);
print_goldbach_list (goldbach_range 1 2000 50)


