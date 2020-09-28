package com.xzy.servlet;

import com.xzy.entity.Contract;
import com.xzy.service.ContractService;
import com.xzy.service.ProductService;
import com.xzy.service.impl.ContractServiceImpl;
import com.xzy.service.impl.ProductServiceImpl;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

@WebServlet("/ContractAddServlet")
public class ContractAddServlet extends HttpServlet {

    private final ContractService CONTRACTSERVICE = new ContractServiceImpl();
    private final ProductService PRODUCTSERVICE = new ProductServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload fileUpload = new ServletFileUpload(factory);
        //设置单个文件为3M
        fileUpload.setFileSizeMax(1024 * 1024 * 3);
        //总文件大小为30M
        fileUpload.setSizeMax(1024 * 1024 * 3 * 10);
        Contract contract = new Contract();
        double total = 0d;
        try {
            List<FileItem> fileItems = fileUpload.parseRequest(request);
            List<Map<String, Integer>> productStockList = new ArrayList<>();
            for (FileItem fileItem : fileItems) {
                if (fileItem.isFormField()) {
                    String fieldName = fileItem.getFieldName();
                    if (fieldName != null && fieldName.equals("contractName")) {
                        contract.setContractName(fileItem.getString("utf-8"));

                    } else if (fieldName != null && fieldName.equals("customerId")) {
                        String string = fileItem.getString("utf-8");
                        contract.setCustomerId(Integer.parseInt(string));

                    } /*else if (fieldName != null && fieldName.equals("contractMoney")) {
                        String string = fileItem.getString("utf-8");
                        contract.setContractMoney(Double.parseDouble(string));

                    }*/ else if (fieldName != null && fieldName.equals("customerSigner")) {
                        contract.setCustomerSigner(fileItem.getString("utf-8"));

                    } else if (fieldName != null && fieldName.equals("employeeSignerId")) {
                        String string = fileItem.getString("utf-8");
                        contract.setEmployeeSignerId(Integer.parseInt(string));

                    } else if (fieldName != null && fieldName.equals("employeeResponsibleId")) {
                        String string = fileItem.getString("utf-8");
                        contract.setEmployeeResponsibleId(Integer.parseInt(string));

                    } else if (fieldName != null && fieldName.equals("employee01Id")) {
                        String string = fileItem.getString("utf-8");
                        contract.setEmployee01Id(Integer.parseInt(string));

                    } else if (fieldName != null && fieldName.equals("employee02Id")) {
                        String string = fileItem.getString("utf-8");
                        contract.setEmployee02Id(Integer.parseInt(string));

                    } else if (fieldName != null && fieldName.equals("startTime")) {
                        String string = fileItem.getString("utf-8");
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                        Date date = sdf.parse(string);
                        contract.setStartTime(date);

                    } else if (fieldName != null && fieldName.equals("endTime")) {
                        String string = fileItem.getString("utf-8");
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                        Date date = sdf.parse(string);
                        contract.setEndTime(date);

                    } else if (fieldName != null && fieldName.equals("productInfo")) {
                        String string = fileItem.getString("utf-8");
                        if (string != null && string.length() > 0) {
                            String[] split = string.split("=");
                            int productId = Integer.parseInt(split[0]);
                            Double price = PRODUCTSERVICE.getProductByProductId(productId).getPrice();
                            int productNum = Integer.parseInt(split[1]);
                            //计算商品价格
                            total += price * productNum;
                            Map<String, Integer> map = new HashMap<>();
                            map.put("productId", productId);
                            map.put("productNum", productNum);
                            productStockList.add(map);
                        }
                    }
                } else {//文件
                    //设置文件的保存路径
                    String realPath = getServletContext().getRealPath("/upload");
                    System.out.println("realPath=" + realPath);
                    //路径虚拟化为一个java对象
                    File file = new File(realPath);
                    if (!file.exists()) {
                        file.mkdirs();
                    }
                    //获取文件的名字
                    String fileName = fileItem.getName();
                    fileName = fileName.substring(fileName.lastIndexOf("."));
                    //重新生成文件名
                    fileName = System.currentTimeMillis() + fileName;
                    System.out.println("文件名" + fileName);
                    //文件保存到指定位置
                    fileItem.write(new File(realPath + "/" + fileName));
                    //fileItem.delete();
                    //将保存的文件路径存到数据库中
                    contract.setContractUrl("/upload/" + fileName);
                }
            }
            contract.setProductStockList(productStockList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //计算总价
        contract.setContractMoney(total);
        contract.setFlag(0);
        //添加合同
        CONTRACTSERVICE.addContract(contract);
        //跳转
        response.sendRedirect("contract_list.jsp");
    }
}
