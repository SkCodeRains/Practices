<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ include file="common/header.jsp" %>
        <%@ include file="common/navigation.jsp" %>
            <div class="bg-transparent p-5 ">
                <div class="card   ">
                    <div class="card-header d-flex">
                        <h5>Hello ! dear ${name} these are your todos</h5>
                    </div>
                    <div class="card-body p-0 m-0 ">
                        <div class="container-fluid pb-3 ">

                            <table class="table table-striped">
                                <thead>
                                    <tr>
                                        <th scope="col">#</th>
                                        <th scope="col">User Name</th>
                                        <th scope="col">Description</th>
                                        <th scope="col">Last Date</th>
                                        <th scope="col">Handled</th>
                                        <th scope="col">DELETE/UPDATE</th>
                                    </tr>
                                </thead>
                                <tbody>

                                    <c:forEach items="${todos}" var="todo">
                                        <tr>
                                            <th scope="row">${todo.id}</th>
                                            <td>${todo.username}</td>
                                            <td>${todo.description}</td>
                                            <td>${todo.targetDate}</td>
                                            <td>${todo.done}</td>
                                            <td>
                                                <a href="delete-todo?id=${todo.id}" class="btn btn-danger">DELETE
                                                    ${todo.id}
                                                </a>
                                                <a href="update-todo?id=${todo.id}" class="btn btn-warning">UPDATE
                                                    ${todo.id}
                                                </a>
                                            </td>

                                        </tr>
                                    </c:forEach>

                                </tbody>
                            </table>

                            <a class="btn btn-primary" href="add-todo"> Add New Todo </a>
                        </div>
                    </div>
                </div>
            </div>
            <%@ include file="common/footer.jsp" %>