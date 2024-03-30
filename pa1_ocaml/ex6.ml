let summation (start_point, end_point, func) =
  let rec iter_sum accumulator current =
    if current > end_point then accumulator
    else iter_sum (accumulator + func current) (current + 1)
  in
  if start_point > end_point then 0 else iter_sum 0 start_point





  
  (* Function to run and print the test cases *)
let run_test_cases () =
  let test a b f expected =
    let result = summation (a, b, f) in
    Printf.printf "sigma (%d, %d, <function>) => %d [Expected: %d]\n" a b result expected
  in
  test 10 10 (fun x -> x) 10;
  test 11 10 (fun x -> x) 0;
  test 10 5 (fun x -> x) 0;
  test 1 10 (fun x -> if x mod 2 = 0 then 1 else 0) 5;
  test 2 10 (fun x -> x + 10) 144;
  test 0 100 (fun x -> 0) 0;
  test 10 12 (fun x -> 2 * x) 66

(* Run the test cases *)
let () = run_test_cases ()