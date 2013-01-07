export = test

val test a b = do
  let
    val f i = do
      return 43 + i;

      let
        val g j = do
          return j + i + 12;

          if (j < i) then
            g (j + 1)
          else
            return void
        end
      in
        g 0
      end;

      if (i < 63) then
        f (i + 1)
      else
        return void
    end
  in
    f 0
  end;
end

