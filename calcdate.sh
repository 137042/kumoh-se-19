cY=$(date +%Y)
cM=$(date +%m)
echo "Date Calculator"
select input in Cur_Year Next_Year Prev_Month Cur_Month Next_Month Quit
do
case $input in
Cur_Year) echo $cY;;
Next_Year) echo `expr $cY + 1`;;
Prev_Month) echo `expr $cM - 1`;;
Cur_Month) echo $cM;;
Next_Month) echo `expr $cM + 1`;;
Quit) break;;
*) echo "Invalid";;
esac
done
