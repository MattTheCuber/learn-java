package calculator;

public class Controller implements ViewsInterface {
	int totalInt;
	Double totalDbl;
	Model model;
	View view;

	public Controller(Model m, View v) {
		view = v;
		model = m;
	}

	@Override
	public void equals() {
		String sign = model.getSign();
		String o = check(model.getOutputTotal());
		String s = check(model.getOutputTotal());
		if (sign.equals("mu")) {
			String strMu[] = str.split("\\×");
			int strL = strMu.length;
			totalInt = Integer.parseInt(strMu[0]);
			for (int i = 1; i < strL; i++) {
				totalInt = totalInt * Integer.parseInt(strMu[i]);
			}
			str = Integer.toString(totalInt);
			view.setText(Double.toString(model.getOutputTotal()));
		} else if (sign.equals("po")) {
			String strPo[] = str.split("\\^");
			int strL = strPo.length;
			totalInt = Integer.parseInt(strPo[0]);
			for (int i = 1; i < strL; i++) {
				int a = Integer.parseInt(strPo[i]);
				double b = Math.pow(totalInt, a);
				totalInt = (int) Math.round(b);
			}
			str = Integer.toString(totalInt);
			view.setText(Double.toString(model.getOutputTotal()));
		} else if (sign.equals("mi")) {
			String strMi[] = str.split("\\-");
			int strL = strMi.length;
			if (strL == 2) {
				totalInt = Integer.parseInt(strMi[0]);
				for (int i = 1; i < strL; i++) {
					totalInt = totalInt - Integer.parseInt(strMi[i]);
				}
				str = Integer.toString(totalInt);
				view.setText(Double.toString(model.getOutputTotal()));
			} else if (strL == 3) {
				totalInt = Integer.parseInt(strMi[0]);
				for (int i = 2; i < strL; i++) {
					totalInt = totalInt - Integer.parseInt(strMi[i]);
				}
				str = Integer.toString(totalInt);
				view.setText(Double.toString(model.getOutputTotal()));
			} else {
				view.setText("Wrong Input");
			}
		} else if (sign.equals("pl")) {
			String strPl[] = str.split("\\+");
			int strL = strPl.length;
			totalInt = Integer.parseInt(strPl[0]);
			for (int i = 1; i < strL; i++) {
				totalInt = totalInt + Integer.parseInt(strPl[i]);
			}
			str = Integer.toString(totalInt);
			view.setText(Double.toString(model.getOutputTotal()));

		} else if (sign.equals("di")) {
			String strDi[] = str.split("\\÷");
			int strL = strDi.length;
			totalDbl = strDi[0]);
			for (int i = 1; i < strL; i++) {
				totalDbl = totalDbl / strDi[i]);
			}
			str = Double.toString(totalDbl);
			view.setText(Double.toString(model.getOutputTotal()));

		} else if ((!sign.equals("di")) && (!sign.equals("pl")) && (!sign.equals("mu")) && (!sign.equals("mi"))) {
			str = "";
			view.setText(Double.toString(model.getOutputTotal()));
		} else {
			view.setText("Wrong Input");
		}
	}

	@Override
	public void pm() {
		String o = check(model.getOutputTotal());
		String s = check(model.getOutputTotal());

		String firstChar = String.valueOf(o.charAt(0));
		String firstChar2 = String.valueOf(s.charAt(0));
		
		if ((firstChar.equals("-"))&&(firstChar2.equals("-"))) {
			o = o.replaceAll(firstChar, "");
			s = s.replaceAll(firstChar, "");
		} else if ((!firstChar.equals("-"))&&(!firstChar2.equals("-"))) {
			o = "-" + o;
			s = "-" + s;
		} else {
			ErrorBox.show();
		}
		model.setOutputTotal(o);
		model.setSystemTotal(s);
		view.setText(o);
	}

	@Override
	public void add(double num) {
		String o = check(model.getOutputTotal());
		String s = check(model.getOutputTotal());

		o += Double.toString(num);
		s += Double.toString(num);
		
		if (o.length() > 15) {
			o.substring(o.length() - 4);
			o += "...";
			MessageBox.show("To long", "Input to long, Input still recorded but not on screen.");
		}
		model.setOutputTotal(o);
		model.setSystemTotal(s);
		view.setText(o);
	}

	@Override
	public void sqrRoot() {
		String o = check(model.getOutputTotal());
		String s = check(model.getOutputTotal());

		String strPox[] = o.split("\\√");
		double totalDbl = Math.sqrt(Double.parseDouble(strPox[0]));

		o = Double.toString(totalDbl);

		String strPoxs[] = s.split("\\√");
		double totalDbls = Math.sqrt(Double.parseDouble(strPoxs[0]));

		s = Double.toString(totalDbls);

		model.setSystemTotal(s);
		model.setOutputTotal(o);
		view.setText(model.getOutputTotal());
	}

	@Override
	public void cubRoot() {
		String o = check(model.getOutputTotal());
		String s = check(model.getOutputTotal());

		String strPox[] = o.split("\\³√");
		double totalDbl = Math.cbrt(Double.parseDouble(strPox[0]));

		o = Double.toString(totalDbl);

		String strPoxs[] = s.split("\\³√");
		double totalDbls = Math.cbrt(Double.parseDouble(strPoxs[0]));

		s = Double.toString(totalDbls);

		model.setSystemTotal(s);
		model.setOutputTotal(o);
		view.setText(model.getOutputTotal());
	}

	@Override
	public void pow2() {
		String o = check(model.getOutputTotal());
		String s = check(model.getOutputTotal());

		String strPox[] = o.split("\\²");
		double totalDbl = Math.pow(Double.parseDouble(strPox[0]), 3.0);

		o = Double.toString(totalDbl);

		String strPoxs[] = s.split("\\²");
		double totalDbls = Math.pow(Double.parseDouble(strPoxs[0]), 3.0);

		s = Double.toString(totalDbls);

		model.setSystemTotal(s);
		model.setOutputTotal(o);
		view.setText(model.getOutputTotal());
	}

	@Override
	public void pow3() {
		String o = check(model.getOutputTotal());
		String s = check(model.getOutputTotal());

		String strPox[] = o.split("\\³");
		double totalDbl = Math.pow(Double.parseDouble(strPox[0]), 3.0);

		o = Double.toString(totalDbl);

		String strPoxs[] = s.split("\\³");
		double totalDbls = Math.pow(Double.parseDouble(strPoxs[0]), 3.0);

		s = Double.toString(totalDbls);

		model.setSystemTotal(s);
		model.setOutputTotal(o);
		view.setText(model.getOutputTotal());
	}

	@Override
	public void powX() {
		String o = check(model.getOutputTotal());
		String s = check(model.getOutputTotal());

		String strPox[] = o.split("\\^");
		double totalDbl = Math.pow(Double.parseDouble(strPox[0]), Double.parseDouble(strPox[0]));

		o = Double.toString(totalDbl);

		String strPoxs[] = s.split("\\^");
		double totalDbls = Math.pow(Double.parseDouble(strPoxs[0]), Double.parseDouble(strPoxs[0]));

		s = Double.toString(totalDbls);

		model.setSystemTotal(s);
		model.setOutputTotal(o);
		view.setText(model.getOutputTotal());
	}

	@Override
	public void bS() {
		String newSTot = "0.0";
		String newOTot = "0.0";
		String o = model.getOutputTotal();
		String s = model.getSystemTotal();
		newSTot = o.substring(0, o.length() - 1);
		newOTot = s.substring(0, s.length() - 1);

		model.setSystemTotal(newSTot);
		model.setOutputTotal(newOTot);
		view.setText(model.getOutputTotal());
	}

	@Override
	public void clear() {
		model.setOutputTotal("0.0");
		model.setSystemTotal("0.0");
		view.setText(model.getOutputTotal());
	}

	@Override
	public void sign(String sign) {
		model.setSign(sign);
		model.setOutputTotal(model.getOutputTotal() + sign);
		model.setOutputTotal(model.getSystemTotal() + sign);
	}

	@Override
	public void addPo(String string) {
		String o = check(model.getOutputTotal());
		String s = check(model.getOutputTotal());

		if (!o.contains(".")) {
			o += string;
			s += string;
		} else if (o.contains(".")) {
			MessageBox.show("Contains", "Number already contains a decimal point.");
		} else {
			ErrorBox.show();
		}

		if (o.length() > 15) {
			o.substring(o.length() - 4);
			o += "...";
			MessageBox.show("To long", "Input to long, Input still recorded but not on screen.");
		}
		model.setOutputTotal(o);
		model.setSystemTotal(s);
		view.setText(o);
	}

	@Override
	public void changePi(double sInt, double oInt) {
		String o = check(model.getOutputTotal());
		String s = check(model.getOutputTotal());

		o = Double.toString(oInt);
		s = Double.toString(sInt);

		if (o.length() > 15) {
			o.substring(o.length() - 4);
			o += "...";
			MessageBox.show("To long", "Input to long, Input still recorded but not on screen.");
		}
		model.setOutputTotal(o);
		model.setSystemTotal(s);
		view.setText(o);
	}

	public String check(String str) {
		String firstchar = "" + str.charAt((str.length()) - 1);
		String secondchar = "" + str.charAt((str.length()) - 2);
		String lastTwo = firstchar + secondchar;
		String newStr;
		if (lastTwo.equals(".0")) {
			newStr = str.substring(str.length() - 2);
		} else {
			newStr = str;
		}
		return newStr;
	}
}
