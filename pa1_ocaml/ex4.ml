
let rec merge list1 list2 = match list1, list2 with
  |  [],  _  -> list2
  |  _,  []  -> list1
  |  h0::t0, h1::t1  ->
    if h0 > h1 then h0 :: merge t0 list2
     else h1 :: merge list1 t1


(* Test cases *)
let () =
  let print_list lst =
    let rec print_elements = function
      | [] -> ()
      | [x] -> print_int x
      | x :: xs -> print_int x; print_string ";"; print_elements xs
    in
    print_string "["; print_elements lst; print_string "]\n"
  in
  print_list (merge [3;2;1] [5;4]);
  print_list (merge [5;3] [5;2]);
  print_list (merge [4;2] []);
  print_list (merge [] [2;1]);
  print_list (merge [] []);
  print_list (merge [0;0;0;0] [0;0;0;0]);
  print_list (merge [4;3;-2] [9;7;7]);
  print_list (merge [-2;-999] [])