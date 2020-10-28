package controller;

import java.math.BigDecimal;
import java.math.RoundingMode;
import javax.swing.JButton;
import javax.swing.JTextField;
import view.CaculatorView;

public class CaculatorController {

    private JTextField text;
    private CaculatorView caculatorview;
    private String operator;
    private boolean process = false, reset = false;
    private BigDecimal firstNumber, secondNumber, memory = new BigDecimal("0");

    public CaculatorController() {
        this.operator = "";
        CaculatorView caculatorview = new CaculatorView();
        this.text = caculatorview.getText();
        caculatorview.getBt0().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pressNumber(caculatorview.getBt0());
            }
        });
        caculatorview.getBt1().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pressNumber(caculatorview.getBt1());
            }
        });
        caculatorview.getBt2().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pressNumber(caculatorview.getBt2());
            }
        });
        caculatorview.getBt3().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pressNumber(caculatorview.getBt3());
            }
        });
        caculatorview.getBt4().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pressNumber(caculatorview.getBt4());
            }
        });
        caculatorview.getBt5().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pressNumber(caculatorview.getBt5());
            }
        });
        caculatorview.getBt6().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pressNumber(caculatorview.getBt6());
            }
        });
        caculatorview.getBt7().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pressNumber(caculatorview.getBt7());
            }
        });
        caculatorview.getBt8().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pressNumber(caculatorview.getBt8());
            }
        });
        caculatorview.getBt9().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pressNumber(caculatorview.getBt9());
            }
        });
        caculatorview.getBtDel().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pressDel();
            }
        });
        caculatorview.getBtDot().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pressDot();
            }
        });
        caculatorview.getBtAllClear().addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pressClear();
            }
        });
        caculatorview.getBtNegate().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pressNegate();
            }
        });
        caculatorview.getBtAdd().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                caculate();
                operator = "+";
            }
        });
        caculatorview.getBtSub().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                caculate();
                operator = "-";
            }
        });
        caculatorview.getBtMultiple().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                caculate();
                operator = "x";
            }
        });
        caculatorview.getBtDivide().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                caculate();
                operator = ":";
            }
        });
        caculatorview.getBtPercent().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pressPercent();
            }

        });
        caculatorview.getBtResult().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pressResult();
            }
        });
        caculatorview.getBtInvert().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pressInvert();
            }

        });
        caculatorview.getBtSqrt().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pressSqrt();
            }

        });
        caculatorview.getBtMadd().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pressMadd();
            }

        });
        caculatorview.getBtMR().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pressMR();
            }

        });
        caculatorview.getBtMsub().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pressMsub();
            }

        });
        caculatorview.getBtMC().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pressMC();
            }

        });
        caculatorview.setVisible(true);

    }

    private void pressClear() {
        text.setText("0");
        process = false;
        firstNumber = secondNumber = memory = new BigDecimal("0");
    }

    public void pressNumber(JButton bt) {
        String value = bt.getText();
        if (text.getText().equals("0") || process || reset) {
            text.setText(value);
            process = false;
            reset = false;
        } else {
            text.setText(text.getText() + value);
        }

    }

    public void pressDel() {
//        if(process){
//            
//            return;
//        }
        String valueTemp = text.getText();
        if (valueTemp.length() == 1 || valueTemp.equals("ERROR") || (valueTemp.length() == 2 && valueTemp.charAt(0) == '-')) {
            text.setText("0");
            return;
        }
        text.setText(valueTemp.substring(0, valueTemp.length() - 1));
    }

    public void pressDot() {
        if (process || reset) {
            text.setText("0");
            process = false;
            reset = false;
        }
        String valueTemp = text.getText();
        if (!valueTemp.contains(".")) {
            text.setText(valueTemp + ".");
        }
    }

    private void pressNegate() {
        if (text.getText().equals("ERROR") || text.getText().equals("0")) {
            return;
        }
        String valueTemp = text.getText();
        if (valueTemp.charAt(0) == '-') {
            text.setText(valueTemp.substring(1));
        } else {
            text.setText("-" + valueTemp);
        }
        process = false;
    }

    private BigDecimal getValue() {
        String valueTemp = text.getText();
        BigDecimal temp;
        try {
            temp = new BigDecimal(valueTemp);
        } catch (Exception e) {
            return firstNumber;
        }
        return temp;
    }

    private void caculate() {
        //process == false
        //process = false
//        !false = true
        //process = true,!true = false
        if (!process) {
            if (operator.equals("")) {
                firstNumber = getValue();
            } else {
                secondNumber = getValue();
                switch (operator) {
                    case "+":
                        firstNumber = firstNumber.add(secondNumber);
                        break;
                    case "-":
                        firstNumber = firstNumber.subtract(secondNumber);
                        break;
                    case "x":
                        firstNumber = firstNumber.multiply(secondNumber);
                        break;
                    case ":":
                        if (secondNumber.toString().equals("0")) {
                            text.setText("ERROR");
                            process = false;
                            reset = true;
                            return;
                        } else {
                            double result = firstNumber.doubleValue() / secondNumber.doubleValue();
//                            if (firstNumber.remainder(secondNumber).toString().equalsIgnoreCase("0")) {
//                                firstNumber = firstNumber.divide(secondNumber);
//                            } else {
                            firstNumber = new BigDecimal(result);

//                            }
                        }
                        break;
                }

            }
            text.setText(firstNumber.toString());
            process = true;
        }
    }

    private void pressResult() {
        if (!text.getText().equals("ERROR")) {
            caculate();
            operator = "";
        } else {
            text.setText(firstNumber + "");
        }

    }

    //1 -> + -> 2 -> = ->
    //first
    private void pressPercent() {
        pressResult();
        if (text.getText().equals("ERROR")) {
            return;
        }
        text.setText(getValue().divide(new BigDecimal(100)).toString());
        reset = true;
//        process = false;
    }

    private void pressInvert() {
        pressResult();
        if (text.getText().equals("0") || text.getText().equals("ERROR")) {
            text.setText("ERROR");
        } else {
            text.setText(1 / getValue().doubleValue() + "");
        }
        reset = true;
    }

    private void pressSqrt() {
        pressResult();
        if (text.getText().charAt(0) == '-') {
            text.setText("ERROR");
        } else {
            String sqrtValue = Math.sqrt(getValue().doubleValue()) + "";
            if (sqrtValue.endsWith(".0")) {
                sqrtValue = sqrtValue.split("\\.")[0];
            }
            text.setText(sqrtValue + "");
        }
        reset = true;
    }

    private void pressMadd() {
        memory = memory.add(getValue());
        reset = true;
    }

    private void pressMR() {
        text.setText(memory.toString());
        reset = true;
    }

    private void pressMsub() {
        memory = memory.subtract(getValue());
        reset = true;
    }

    private void pressMC() {
        memory = new BigDecimal("0");
        reset = true;
    }
}
