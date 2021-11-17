package recursion;

public class CheckPalindrome {

	public static void main(String[] args) {
		String s = "mnschgziwincvcrhegtkkgzuewasvstiogqaijvtvikjjivatyqbnsrnfcrhxlkkrrqrmze"
				+ "miqbujbktdnejobxtcjiibcfynrfxbbqwujyleetwwalbuewgewkdrefcdptqgpqhqvgunia"
				+ "pbdzdxexeealxmtbmlsdihyllmnmltghyetghrtmpimqepumuzvkdmxvyoweexxckmyqtirj"
				+ "nebodjmuzozmvypdcalffowunzrlflvmimxhemvlhobeenpcvynchlxpsdvlmeddahnvkspu"
				+ "qhgrxdukrhtbtlpxyblucxuyoowsxgtqeiotylvonaublmozlvwsphfilxfncegpleebaiuf"
				+ "djmpiolgdbfcshbwjchuxumyxhhrujifbcehsniqpghdztvztxvliztiqzwaktqohpntxey"
				+ "feaijldzhnsyvhjixlymtmrfvzlqgdomawrfddcagjagvcfhbyqgixyqbbpyjijeviyhwrig"
				+ "nduetolptfyvmklmdrxqvrdnwssvgujqfwukneddqdvvqxxmuhtxuiufbqxswstgrykpoei"
				+ "izmbpoturgrnvsshhzoppyktljqxxuhcdfsmesaimxicxfslnfagdfaoczbhivhxmotzbpu"
				+ "lduuczfyeijkkcwmqqtrqstwiqmkatyjotoexkeesprwzfxwzshwlqfssryxxvybnrxdiuu"
				+ "svnnlfabkpynsakpnftjqhecuwmyqgwhyrtudmkfcphnnyxqxzxbucfewihqmjjnblrmyer"
				+ "tspotzfgzvabnhcxklqdlbtvvqwynenkkhxcjsndltankzkmrkknbkxjqzabatkcdvodhzzm"
				+ "qqcfwshhufezzddzrfldwxylaylpfqpiczfmyymfzcipqfplyalyxwdlfrzddzzefuhhswf"
				+ "cqqmzzhdovdcktabazqjxkbnkkrmkzknatldnsjcxhkknenywqvvtbldqlkxchnbavzgfzto"
				+ "pstreymrlbnjjmqhiwefcubxzxqxynnhpcfkmdutryhwgqymwucehqjtfnpkasnypkbafln"
				+ "nvsuuidxrnbyvxxyrssfqlwhszwxfzwrpseekxeotojytakmqiwtsqrtqqmwckkjieyfzcu"
				+ "udlupbztomxhvihbzcoafdgafnlsfxcixmiasemsfdchuxxqjltkyppozhhssvnrgrutopb"
				+ "mziieopkyrgtswsxqbfuiuxthumxxqvvdqddenkuwfqjugvsswndrvqxrdmlkmvyftplote"
				+ "udngirwhyivejijypbbqyxigqybhfcvgajgacddfrwamodgqlzvfrmtmylxijhvysnhzdlj"
				+ "iaefyextnphoqtkawzqitzilvxtzvtzdhgpqinshecbfijurhhxymuxuhcjwbhscfbdglo"
				+ "ipmjdfuiabeelpgecnfxlifhpswvlzomlbuanovlytoieqtgxswooyuxculbyxpltbthr"
				+ "kudxrghqupskvnhaddemlvdspxlhcnyvcpneebohlvmehxmimvlflrznuwofflacdpyvm"
				+ "zozumjdobenjritqymkcxxeewoyvxmdkvzumupeqmipmtrhgteyhgtlmnmllyhidslmbt"
				+ "mxlaeexexdzdbpainugvqhqpgqtpdcferdkwegweublawwteelyjuwqbbxfrnyfcbiij"
				+ "ctxbojendtkbjubqimezmrqrrkklxhrcfnrsnbqytavijjkivtvjiaqgoitsvsaweuzgk"
				+ "ktgehrcvcniwizghcsnm";
		System.out.println(palindrome(s, 0, s.length() - 1));
	}

	public static boolean palindrome(String str, int start, int end) {
		if (start > end)
			return true;
		return palindrome(str, start+1, end-1) && (str.charAt(start) == str.charAt(end));
	}

}
