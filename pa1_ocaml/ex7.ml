let rec fold3 combiner accum lst1 lst2 lst3 = 
  match (lst1, lst2, lst3) with
  | [], [], [] -> accum
  | h1::t1, h2::t2, h3::t3 -> fold3 combiner (combiner accum h1 h2 h3) t1 t2 t3
  | _ -> failwith "Lists are of different lengths!"





  let run_tests () =
    let checkit funky_combine start list1 list2 list3 expected =
      let result = fold3 funky_combine start list1 list2 list3 in
      Printf.printf "Test with start %d -> Result: %d, Expected: %d\n" start result     expected
    in
    checkit (fun acc b c d -> acc + b + c + d) 10 [33;67;12;33] [10;23;84;57] [11;55;23;58] 476;
    checkit (fun acc b c d -> (-acc) + b + c + d) 4 [11;63;-45;22] [75;123;-44;1] [55;24;20;3] 168;
    checkit (fun acc b c d -> acc * b * c * d) 55 [] [] [] 55;
    checkit (fun acc b c d -> (acc * b * c + d) mod 7) 33 [12;33] [10;7] [5;12] 5;
    checkit (fun acc b c d -> if b then acc + c else acc + d) 34 [true;false;false;true] [12;3;4;77] [11;23;6;100] 152;
    checkit (fun acc b c d -> if b then acc + c else acc + d) 55 [true;true;false;false;true] [11;63;88;123;98] [0;23;778;34;6] 157;;
 
  let () = run_tests ();;