package processor;
import java.util.Locale;
import java.util.Scanner;
public class Main {

    private static double[][] askMatrix(String matrixNumber){
        System.out.print("Enter size of " + matrixNumber + "matrix: ");
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        double[][] matrix = new double[n][m];
        System.out.println("Enter " + matrixNumber + "matrix:");
        for(int i = 0; i < n; i++){
            for (int j = 0; j < m; j++) {
                matrix[i][j] = scanner.nextDouble();
            }
        }
        return matrix;
    }
    private static void matrixPrint(double[][] matrix){
        String[][] strMatrix = new String[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] % 1 != 0){
                    strMatrix[i][j] = "" + Math.round(matrix[i][j] * 100) * 0.01;
                }else{
                    strMatrix[i][j] = "" + (int)matrix[i][j];
                }
            }
        }
        int[] maxLength = new int[strMatrix[0].length];
        for (int i = 0; i < strMatrix[0].length; i++) {
            maxLength[i] = strMatrix[0][i].length();
            for (int j = 1; j < strMatrix.length; j++) {
                if(maxLength[i] < strMatrix[j][i].length()){
                    maxLength[i] = strMatrix[j][i].length();
                }
            }
        }
        for (int i = 0; i < strMatrix.length; i++) {
            for (int j = 0; j < strMatrix[0].length; j++) {
                for(int k = 0; k < maxLength[j] - strMatrix[i][j].length(); k++){
                    System.out.print(" ");
                }
                System.out.print(strMatrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    private static void add (){
        double[][] first = askMatrix("first ");
        double[][] second = askMatrix("second ");
        if(first.length == second.length && first[0].length == second[0].length){
            double[][] result = new double[first.length][first[0].length];
            for(int i = 0; i < first.length; i++){
                for(int j = 0; j < first[0].length; j++){
                    result[i][j] = first[i][j] + second[i][j];
                }
            }
            System.out.println("The adding result is:");
            matrixPrint(result);
        }else{
            System.out.println("ERROR");
        }
    }
    private static double askConst (){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a constant: ");
        return scanner.nextDouble();
    }
    private static void multiConst (){
        double[][] matrix = askMatrix("");
        double constant = askConst();
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                matrix[i][j] = matrix[i][j] * constant;
            }
        }
        System.out.println("The multiplication matrix to a constant result is:");
        matrixPrint(matrix);
    }
    private static double[][] multiConst (double constant, double[][] matrix){
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                matrix[i][j] = matrix[i][j] * constant;
            }
        }
        return matrix;
    }
    private static void multiMatrix (){
        double[][] first = askMatrix("first ");
        double[][] second = askMatrix("second ");
        if (first[0].length != second.length) {
            System.out.println("ERROR");
            return;
        }
        double[][] result = new double[first.length][second[0].length];
        for (int i = 0; i < first.length; i++) {
            for (int j = 0; j < second[0].length; j++) {
                for (int k = 0; k < first[0].length; k++) {
                    result[i][j] += first[i][k] * second[k][j];
                }
            }
        }
        System.out.println("The multiplication result is:");
        matrixPrint(result);
    }
    private static void transMatrix(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("1. Main diagonal");
        System.out.println("2. Side diagonal");
        System.out.println("3. Vertical line");
        System.out.println("4. Horizontal line");
        System.out.print("Your choice: ");
        int choiceTrans = scanner.nextInt();
        if(choiceTrans == 1){
            transMain();
        }else if(choiceTrans == 2){
            transSide();
        }else if(choiceTrans == 3){
            transVertical();
        }else if(choiceTrans == 4){
            transHorizontal();
        }else{
            System.out.println("Wrong input!");
        }
    }
    private static void transMain(){
        double[][] matrix = askMatrix("");
        if (matrix.length == matrix[0].length){
            double[][] result = new double[matrix.length][matrix[0].length];
            for(int i = 0; i < matrix.length; i++){
                for(int j = 0; j < matrix[0].length; j++){
                    result[i][j] = matrix[j][i];
                }
            }
            System.out.println("The result is:");
            matrixPrint(result);
        }else{
            System.out.println("ERROR");
        }
    }
    private static double[][] transMain(double[][] matrix){
        double[][] result = new double[matrix.length][matrix[0].length];
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                result[i][j] = matrix[j][i];
            }
        }
        return result;
    }
    private static void transSide(){
        double[][] matrix = askMatrix("");
        if (matrix.length == matrix[0].length){
            double[][] result = new double[matrix.length][matrix[0].length];
            for(int i = 0; i < matrix.length; i++){
                for(int j = 0; j < matrix[0].length; j++){
                    result[i][j] = matrix[matrix.length - 1 - j][matrix.length - 1 - i];
                }
            }
            System.out.println("The result is:");
            matrixPrint(result);
        }else{
            System.out.println("ERROR");
        }
    }
    private static void transVertical(){
        double[][] matrix = askMatrix("");
        double[][] result = new double[matrix.length][matrix[0].length];
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                result[i][j] = matrix[i][matrix[0].length - 1 - j];
            }
        }
        System.out.println("The result is:");
        matrixPrint(result);
    }
    private static void transHorizontal(){
        double[][] matrix = askMatrix("");
        double[][] result = new double[matrix.length][matrix[0].length];
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                result[i][j] = matrix[matrix.length - 1 - i][j];
            }
        }
        System.out.println("The result is:");
        matrixPrint(result);
    }
    private static void determMatrix(){
        double[][] matrix = askMatrix("");
        if (matrix.length == matrix[0].length){
            double result = determRecoursy(matrix);
            System.out.println("The result is:");
            System.out.println(result);
        }else{
            System.out.println("ERROR");
        }
    }
    private static double determRecoursy(double[][] matrix){
        if(matrix.length < 3){
             return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
        }else{
            double det = 0;
            double[][] newMatrix = new double[matrix.length - 1][matrix.length - 1];
            for(int row = 0; row < matrix.length; row++){
                int k = 0;
                int m;
                for(int i = 1; i < matrix.length; i++){
                    m = 0;
                    for(int j = 0; j < matrix.length; j++){
                        if(j != row){
                            newMatrix[k][m] = matrix[i][j];
                            m++;
                        }
                    }
                    k++;
                }
                if(row % 2 == 0){
                    det += matrix[0][row] * determRecoursy(newMatrix);
                }else{
                    det -= matrix[0][row] * determRecoursy(newMatrix);
                }
            }
            return det;
        }
    }
    private static void inverseMatrix(){
        double[][] matrix = askMatrix("");
        if (matrix.length == matrix[0].length){
            double det = determRecoursy(matrix);
            if(det == 0){
                System.out.println("Inverse matrix can’t be found");
                return;
            }
            double[][] cMatrix = getCMatrix(matrix);
            double[][] result = multiConst(1 / det, cMatrix);
            System.out.println("The result is:");
            matrixPrint(result);
        }else{
            System.out.println("ERROR");
        }
    }
    private static double[][] getCMatrix(double[][] matrix){
        double[][] cMatrix = new double[matrix.length][matrix[0].length];
        if(matrix.length < 3){
            cMatrix[0][0] = matrix[1][1];
            cMatrix[1][1] = matrix[0][0];
            cMatrix[0][1] = - matrix[0][1];
            cMatrix[1][0] = - matrix[1][0];
        }else{
            double[][] newMatrix = new double[matrix.length - 1][matrix.length - 1];
            int m;
            int k;
            for(int x = 0; x < matrix.length; x++) {
                for(int y = 0; y < matrix.length; y++) {
                    k = 0;
                    for (int i = 0; i < matrix.length; i++) {
                        m = 0;
                        if(i != x) {
                            for (int j = 0; j < matrix.length; j++) {
                                if (j != y) {
                                    newMatrix[k][m] = matrix[i][j];
                                    m++;
                                }
                            }
                            k++;
                        }
                    }
                    cMatrix[x][y] = Math.pow(- 1, x + y) * determRecoursy(newMatrix);
                }
            }
            cMatrix = transMain(cMatrix);
        }
        return cMatrix;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        while (true){
            System.out.println("1. Add matrices");
            System.out.println("2. Multiply matrix to a constant");
            System.out.println("3. Multiply matrices");
            System.out.println("4. Transpose matrix");
            System.out.println("5. Calculate a determinant");
            System.out.println("6. Inverse matrix");
            System.out.println("0. Exit");
            System.out.print("Your choice: ");
            choice = scanner.nextInt();
            if(choice == 1){
                add();
            }else if(choice == 2){
                multiConst();
            }else if(choice == 3){
                multiMatrix();
            }else if(choice == 4){
                transMatrix();
            }else if(choice == 5){
                determMatrix();
            }else if(choice == 6){
                inverseMatrix();
            }else if(choice == 0){
                break;
            }else{
                System.out.println("Wrong input!");
            }
        }
        /*public enum MatrixProcessor{
        MENU,
        ADD,
        MULTI_CONST,
        MULTI_MATRIX,
        EXIT;
    }
    private static void printMenu (){
        System.out.println("1. Add matrices");
        System.out.println("2. Multiply matrix to a constant");
        System.out.println("3. Multiply matrices");
        System.out.println("0. Exit");
        System.out.print("Your choice: ");
    }
    private static MatrixProcessor choice(){
        printMenu();
        Scanner scanner = new Scanner(System.in);
        String num = scanner.next();
        MatrixProcessor matrixProcessor;
        switch (num){
            case "1":
                matrixProcessor = MatrixProcessor.ADD;
                break;
            case "2":
                matrixProcessor = MatrixProcessor.MULTI_CONST;
                break;
            case "3":
                matrixProcessor = MatrixProcessor.MULTI_MATRIX;
                break;
            case "0":
                matrixProcessor = MatrixProcessor.EXIT;
                break;
            default:
                System.out.println("Wrong input!");
                matrixProcessor = MatrixProcessor.MENU;
                break;
        }
        return matrixProcessor;
    }*/
        /*private static MatrixProcessor add (){
        double[][] first = askMatrix("first ");
        double[][] second = askMatrix("second ");
        if(first.length == second.length && first[0].length == second[0].length){
            double[][] result = new double[first.length][first[0].length];
            for(int i = 0; i < first.length; i++){
                for(int j = 0; j < first[0].length; j++){
                    result[i][j] = first[i][j] + second[i][j];
                }
            }
            System.out.println("The adding result is:");
            matrixPrint(result);
        }else{
            System.out.println("ERROR");
        }
        return MatrixProcessor.MENU;
    }*/
        /*private static MatrixProcessor multiConst (){
        double[][] matrix = askMatrix("");
        double constant = askConst();
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                matrix[i][j] = matrix[i][j] * constant;
            }
        }
        System.out.println("The multiplication matrix to a constant result is:");
        matrixPrint(matrix);
        return MatrixProcessor.MENU;
    }*/
        /*private static MatrixProcessor multiMatrix (){
        double[][] first = askMatrix("first ");
        double[][] second = askMatrix("second ");
        if (first[0].length != second.length) {
            System.out.println("ERROR");
            return MatrixProcessor.MENU;
        }
        double[][] result = new double[second.length][second[0].length];
        for (int i = 0; i < second.length; i++) {
            for (int j = 0; j < second[0].length; j++) {
                for (int k = 0; k < second.length; k++) {
                    result[j][i] += first[j][k] * second[k][i];
                }
            }
        }
        System.out.println("The multiplication result is:");
        matrixPrint(result);
        return MatrixProcessor.MENU;
    }*/
        /*MatrixProcessor matrixProcessor = MatrixProcessor.MENU;
        while(matrixProcessor != MatrixProcessor.EXIT){
            if(matrixProcessor == MatrixProcessor.MENU){
                matrixProcessor = choice();
            }
            if(matrixProcessor == MatrixProcessor.ADD){
                matrixProcessor = add();
            }
            if (matrixProcessor == MatrixProcessor.MULTI_CONST){
                matrixProcessor = multiConst();
            }
            if (matrixProcessor == MatrixProcessor.MULTI_MATRIX){
                matrixProcessor = multiMatrix();
            }
        }*/
    }
}
