from mcp.server.fastmcp import FastMCP
import json
mcp = FastMCP("python-mcp")

@mcp.tool(name="get_employee_info")
def get_employee_info(name:str) -> str:
    """
    Get Info about given employee name
    :param name: employee name
    :return: dictionary
    """
    print("Le tool est applé")
    return json.dumps({
        "employee_name": name,
        "salary": 5400
    })

if __name__ == "__main__":
    mcp.run(transport="stdio")